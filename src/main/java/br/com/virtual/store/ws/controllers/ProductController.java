package br.com.virtual.store.ws.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtual.store.ws.dto.BuyProductDTO;
import br.com.virtual.store.ws.dto.CreateProductDTO;
import br.com.virtual.store.ws.dto.UpdateProductDTO;
import br.com.virtual.store.ws.entities.BoughtProducts;
import br.com.virtual.store.ws.entities.Product;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.request.BuyProductRequest;
import br.com.virtual.store.ws.request.CreateProductRequest;
import br.com.virtual.store.ws.request.DeleteProductRequest;
import br.com.virtual.store.ws.request.UpdateProductRequest;
import br.com.virtual.store.ws.response.BoughtProductResponse;
import br.com.virtual.store.ws.response.CreateErrorResponse;
import br.com.virtual.store.ws.response.CreatedProductResponse;
import br.com.virtual.store.ws.service.ProductService;
import br.com.virtual.store.ws.util.CheckRequest;

@CrossOrigin
@RestController
@RequestMapping("/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createProduct(@RequestBody CreateProductRequest createProductRequestParameter) {
		try {

			new CheckRequest().checkCreateProductRequests(createProductRequestParameter);
			CreateProductDTO createProductRequestDto = new CreateProductDTO();
			BeanUtils.copyProperties(createProductRequestParameter, createProductRequestDto);
			Product product = productService.createProduct(createProductRequestDto);
			return new ResponseEntity<CreatedProductResponse>(new CreatedProductResponse.Builder()
					.withProductValue(product.getProductValue()).withProductName(product.getProductName())
					.withProductDescription(product.getProductDescription())
					.withCreatedProductDate(product.getCreatedProductDate()).Build(), HttpStatus.CREATED);
		} catch (ProductException e1) {
			return CreateErrorResponse.createResponseErrorForProduct(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteProduct(@RequestBody DeleteProductRequest deleteProductRequest) {
		try {
			if (deleteProductRequest.getProductId() != null) {
				productService.deleteProduct(deleteProductRequest.getProductId());
				return new ResponseEntity<String>("Product Deleted!", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Product Was Not Deleted Deleted!", HttpStatus.BAD_REQUEST);
			}

		} catch (ProductException e1) {
			return CreateErrorResponse.createResponseErrorForProduct(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest updateProductRequestParameter) {
		try {

			new CheckRequest().checkUpdateProductRequests(updateProductRequestParameter);

			UpdateProductDTO updateProductDTO = new UpdateProductDTO();

			BeanUtils.copyProperties(updateProductRequestParameter, updateProductDTO);

			productService.updateProduct(updateProductDTO);

			return new ResponseEntity<String>("Product Updated!", HttpStatus.OK);
		} catch (ProductException e1) {
			return CreateErrorResponse.createResponseErrorForProduct(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@PostMapping("/buy")
	public ResponseEntity<?> buyProduct(@RequestBody BuyProductRequest buyProductRequestParameter) {
		try {

			new CheckRequest().checkBuyProductRequests(buyProductRequestParameter);

			BuyProductDTO buyProductDTO = new BuyProductDTO();

			BeanUtils.copyProperties(buyProductRequestParameter, buyProductDTO);

			BoughtProducts boughtProduct = productService.buyProduct(buyProductDTO);

			return new ResponseEntity<BoughtProductResponse>(
					new BoughtProductResponse.Builder().withBarCodeMock(boughtProduct.getBarCodeMock()).Build(),
					HttpStatus.OK);
		} catch (ProductException e1) {
			return CreateErrorResponse.createResponseErrorForProduct(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}
}
