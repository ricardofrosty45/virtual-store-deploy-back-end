package br.com.virtual.store.ws.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtual.store.ws.dto.BuyProductDTO;
import br.com.virtual.store.ws.dto.CreateProductDTO;
import br.com.virtual.store.ws.dto.UpdateProductDTO;
import br.com.virtual.store.ws.entities.BoughtProducts;
import br.com.virtual.store.ws.entities.Product;
import br.com.virtual.store.ws.enums.StatusProduct;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.repository.BuyProductRepository;
import br.com.virtual.store.ws.repository.ProductRepository;
import br.com.virtual.store.ws.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private BuyProductRepository buyProductRepository;

	@Override
	public Product createProduct(CreateProductDTO userDto) throws ProductException{
		Product entity = new Product();
		BeanUtils.copyProperties(userDto, entity);
		entity.setCreatedProductDate(new Date());
		return repository.save(entity);
	}

	@Override
	public void updateProduct(UpdateProductDTO updateProductDto)throws ProductException {
		Optional<Product> product = repository.findById(updateProductDto.getIdProduct());
		Product productEntity = product.get();
		productEntity.setProductDescription(updateProductDto.getProductDescription());
		productEntity.setProductName(updateProductDto.getProductName());
		productEntity.setProductValue(updateProductDto.getProductValue());
		repository.save(productEntity);
	}

	@Override
	public void deleteProduct(String id)throws ProductException {
		repository.deleteById(id);
	}

	@Override
	public BoughtProducts buyProduct(BuyProductDTO buyProductDTO) throws ProductException{

		Product productEntity = updateProductStatus(buyProductDTO);
		BoughtProducts boughtProductsEntity = new BoughtProducts();
		boughtProductsEntity.setBarCodeMock(barCodeMock());
		boughtProductsEntity.setCreatedBuyDate(new Date());
		boughtProductsEntity.setProductName(productEntity.getProductName());
		boughtProductsEntity.setProductValue(productEntity.getProductValue());
		boughtProductsEntity.setStatusProduct(StatusProduct.SOLD);
		buyProductRepository.save(boughtProductsEntity);

		return boughtProductsEntity;
	}

	private Product updateProductStatus(BuyProductDTO buyProductDTO) {
		Optional<Product> product = repository.findById(buyProductDTO.getIdProduct());
		Product productEntity = product.get();
		productEntity.setStatusProduct(StatusProduct.SOLD);
		repository.save(productEntity);
		return productEntity;
	}

	private String barCodeMock() {
		Random randomNumber = new Random();
		String barCodeMock = randomNumber.nextInt(6) + "." + randomNumber.nextInt(5) + "." + randomNumber.nextInt(3)
				+ ".0." + randomNumber.nextInt(6) + "-" + randomNumber.nextInt(4) + "000000" + randomNumber.nextInt(3);
		return barCodeMock;
	}

}
