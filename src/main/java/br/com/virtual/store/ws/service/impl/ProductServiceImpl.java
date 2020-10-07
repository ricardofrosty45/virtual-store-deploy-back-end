package br.com.virtual.store.ws.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtual.store.ws.dto.BuyProductDTO;
import br.com.virtual.store.ws.dto.CreateProductDTO;
import br.com.virtual.store.ws.dto.UpdateProductDTO;
import br.com.virtual.store.ws.entities.BoughtProducts;
import br.com.virtual.store.ws.entities.ClientSpendings;
import br.com.virtual.store.ws.entities.Product;
import br.com.virtual.store.ws.entities.User;
import br.com.virtual.store.ws.enums.ProductEnumErrors;
import br.com.virtual.store.ws.enums.StatusProduct;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.repository.BuyProductRepository;
import br.com.virtual.store.ws.repository.ClientSpendingsRepository;
import br.com.virtual.store.ws.repository.ProductRepository;
import br.com.virtual.store.ws.repository.UserRepository;
import br.com.virtual.store.ws.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private BuyProductRepository buyProductRepository;

	@Autowired
	private UserRepository userRespository;

	@Autowired
	private ClientSpendingsRepository clienteSpendingsRepository;

	@Override
	public Product createProduct(CreateProductDTO userDto) throws ProductException {
		Product entity = new Product();
		BeanUtils.copyProperties(userDto, entity);
		entity.setCreatedProductDate(new Date());
		entity.setStatusProduct(StatusProduct.NOT_SOLD);
		return repository.save(entity);
	}

	@Override
	public void updateProduct(UpdateProductDTO updateProductDto) throws ProductException {
		Optional<Product> product = repository.findById(updateProductDto.getIdProduct());
		Product productEntity = product.get();
		productEntity.setProductDescription(updateProductDto.getProductDescription());
		productEntity.setProductName(updateProductDto.getProductName());
		productEntity.setProductValue(updateProductDto.getProductValue());
		repository.save(productEntity);
	}

	@Override
	public void deleteProduct(String id) throws ProductException {
		repository.deleteById(id);
	}

	@Override
	public BoughtProducts buyProduct(BuyProductDTO buyProductDTO) throws ProductException {

		Product productEntity = updateProductStatus(buyProductDTO);
		List<String> clientSpendingTags = new ArrayList<String>();
		BoughtProducts boughtProductsEntity = new BoughtProducts();
		ClientSpendings clientSpendings = new ClientSpendings();
		boughtProductsEntity.setBarCodeMock(barCodeMock());
		boughtProductsEntity.setCreatedBuyDate(new Date());
		boughtProductsEntity.setProductName(productEntity.getProductName());
		boughtProductsEntity.setProductValue(productEntity.getProductValue());
		boughtProductsEntity.setStatusProduct(StatusProduct.SOLD);
		Optional<User> userOptional = userRespository.findById(buyProductDTO.getClientId());
		User user = userOptional.get();
		int spendings = user.getClientSpendings().intValue() + productEntity.getProductValue().intValue();
		user.setClientSpendings(user.getClientSpendings().add(new BigDecimal(spendings)));
		clientSpendings.setClientId(user.getId());
		clientSpendings.setClientName(user.getName());
		clientSpendings.setDescription("This Client Bought This Product:" + productEntity.getProductName());
		clientSpendings.setTodaysDateSpendings(new Date(System.currentTimeMillis()));
		clientSpendings.setClientSpendings(new BigDecimal(spendings));
		clientSpendingTags.add("Client");
		clientSpendingTags.add(productEntity.getProductName());
		clientSpendings.setTags(clientSpendingTags);
		clienteSpendingsRepository.save(clientSpendings);
		userRespository.save(user);
		buyProductRepository.save(boughtProductsEntity);
		return boughtProductsEntity;
	}

	private Product updateProductStatus(BuyProductDTO buyProductDTO) throws ProductException {
		Optional<Product> product = repository.findById(buyProductDTO.getIdProduct());
		Product productEntity = product.get();
		if (productEntity.getStatusProduct() == StatusProduct.SOLD) {
			throw new ProductException(ProductEnumErrors.PRODUCT_ALREADY_BOUGHT.message,
					ProductEnumErrors.PRODUCT_ALREADY_BOUGHT.wrongField,
					ProductEnumErrors.PRODUCT_ALREADY_BOUGHT.errorCode);
		}
		productEntity.setStatusProduct(StatusProduct.SOLD);
		repository.save(productEntity);
		return productEntity;
	}

	private String barCodeMock() {
		Random randomNumber = new Random();
		String barCodeMock = randomNumber.nextInt(6000) + "." + randomNumber.nextInt(50000) + "."
				+ randomNumber.nextInt(3) + ".0." + randomNumber.nextInt(60000) + "-" + randomNumber.nextInt(40000)
				+ "000000" + randomNumber.nextInt(3000);
		return barCodeMock;
	}

}
