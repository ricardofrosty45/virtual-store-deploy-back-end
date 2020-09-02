package br.com.virtual.store.ws.service.impl.test;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import br.com.virtual.store.ws.dto.CreateProductDTO;
import br.com.virtual.store.ws.entities.Product;
import br.com.virtual.store.ws.enums.StatusProduct;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.repository.BuyProductRepository;
import br.com.virtual.store.ws.repository.ProductRepository;
import br.com.virtual.store.ws.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productService;

	@Mock
	private ProductRepository repository;

	@Mock
	private BuyProductRepository buyProductRepository;

	@Test
	public void createProductGoodPath() throws ProductException {

		when(repository.save(new Product())).thenReturn(new Product());
		Product product = productService.createProduct(new CreateProductDTO());
		assertNotNull(product);
	}

	@Test
	public void createProductCouldNotSave() throws ProductException {

		CreateProductDTO dto = new CreateProductDTO();

		dto.setProductValue(new BigDecimal(0));
		dto.setCreatedProductDate(new Date());
		dto.setStatusProduct(StatusProduct.NOT_SOLD);

		Product entitySend = new Product();
		entitySend.setProductValue(new BigDecimal(0));
		entitySend.setCreatedProductDate(new Date());
		entitySend.setStatusProduct(StatusProduct.NOT_SOLD);
		when(repository.save(entitySend)).thenThrow(IllegalArgumentException.class);
		productService.createProduct(dto);
	}

}
