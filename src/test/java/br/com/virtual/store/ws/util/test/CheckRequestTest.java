package br.com.virtual.store.ws.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.request.BuyProductRequest;
import br.com.virtual.store.ws.request.UpdateProductRequest;
import br.com.virtual.store.ws.util.CheckRequest;

public class CheckRequestTest {

	private CheckRequest checkRequests;

	@Before
	public void init() {
		checkRequests = new CheckRequest();
	}

	@Test
	public void checkBuyProductRequestsGoodPathTest() throws ProductException {
		BuyProductRequest buyProductRequests = new BuyProductRequest();
		buyProductRequests.setIdProduct("123");
		checkRequests.checkBuyProductRequests(buyProductRequests);
		assertEquals(buyProductRequests.getIdProduct(), "123");
	}

	@Test(expected = ProductException.class)
	public void checkBuyProductRequestsNullErrorTest() throws ProductException {
		checkRequests.checkBuyProductRequests(null);
	}

	@Test(expected = ProductException.class)
	public void checkBuyProductRequestsIdIsNullErrorTest() throws ProductException {
		BuyProductRequest buyProductRequests = new BuyProductRequest();
		checkRequests.checkBuyProductRequests(buyProductRequests);
	}

	@Test(expected = ProductException.class)
	public void checkBuyProductRequestsIdIsEmptyErrorTest() throws ProductException {
		BuyProductRequest buyProductRequests = new BuyProductRequest();
		buyProductRequests.setIdProduct("");
		checkRequests.checkBuyProductRequests(buyProductRequests);
	}

	@Test
	public void checkUpdateProductRequestsGoodPathTest() throws ProductException {
		UpdateProductRequest buyProductRequests = new UpdateProductRequest();
		buyProductRequests.setIdProduct("123");
		buyProductRequests.setProductDescription("123");
		buyProductRequests.setProductName("123");
		buyProductRequests.setProductValue(new BigDecimal(1));
		checkRequests.checkUpdateProductRequests(buyProductRequests);
	}

	@Test(expected = ProductException.class)
	public void checkUpdateProductRequestsUpdateProductRequestsIsNullTest() throws ProductException {
		checkRequests.checkUpdateProductRequests(null);
	}

	@Test(expected = ProductException.class)
	public void checkUpdateProductRequestsProductIdIsNullTest() throws ProductException {
		UpdateProductRequest buyProductRequests = new UpdateProductRequest();
		buyProductRequests.setIdProduct(null);
		buyProductRequests.setProductDescription("123");
		buyProductRequests.setProductName("123");
		buyProductRequests.setProductValue(new BigDecimal(1));
		checkRequests.checkUpdateProductRequests(buyProductRequests);
	}

	@Test(expected = ProductException.class)
	public void checkUpdateProductRequestsProductIdIsEmptyTest() throws ProductException {
		UpdateProductRequest buyProductRequests = new UpdateProductRequest();
		buyProductRequests.setIdProduct("");
		buyProductRequests.setProductDescription("123");
		buyProductRequests.setProductName("123");
		buyProductRequests.setProductValue(new BigDecimal(1));
		checkRequests.checkUpdateProductRequests(buyProductRequests);
	}

	@Test(expected = ProductException.class)
	public void checkUpdateProductRequestsProductDescriptionIsNullTest() throws ProductException {
		UpdateProductRequest buyProductRequests = new UpdateProductRequest();
		buyProductRequests.setProductDescription(null);
		buyProductRequests.setIdProduct("123");
		buyProductRequests.setProductName("123");
		buyProductRequests.setProductValue(new BigDecimal(1));
		checkRequests.checkUpdateProductRequests(buyProductRequests);
	}

	@Test(expected = ProductException.class)
	public void checkUpdateProductRequestsProductDescriptionIsEmptyTest() throws ProductException {
		UpdateProductRequest buyProductRequests = new UpdateProductRequest();
		buyProductRequests.setProductDescription("");
		buyProductRequests.setIdProduct("123");
		buyProductRequests.setProductName("123");
		buyProductRequests.setProductValue(new BigDecimal(1));
		checkRequests.checkUpdateProductRequests(buyProductRequests);
	}

	@Test(expected = ProductException.class)
	public void checkUpdateProductRequestsProductNameIsNullTest() throws ProductException {
		UpdateProductRequest buyProductRequests = new UpdateProductRequest();
		buyProductRequests.setIdProduct("123");
		buyProductRequests.setProductDescription("123");
		buyProductRequests.setProductName(null);
		buyProductRequests.setProductValue(new BigDecimal(1));
		checkRequests.checkUpdateProductRequests(buyProductRequests);
	}

}
