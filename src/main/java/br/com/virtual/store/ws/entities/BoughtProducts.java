package br.com.virtual.store.ws.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.virtual.store.ws.enums.StatusProduct;

@Document(collection = "BoughtProducts")
public class BoughtProducts {
	@Id
	private String id;

	private String productName;

	private BigDecimal productValue;

	private StatusProduct statusProduct;

	private Date createdBuyDate;
	
	private String barCodeMock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductValue() {
		return productValue;
	}

	public void setProductValue(BigDecimal productValue) {
		this.productValue = productValue;
	}

	public Date getCreatedBuyDate() {
		return createdBuyDate;
	}

	public void setCreatedBuyDate(Date createdBuyDate) {
		this.createdBuyDate = createdBuyDate;
	}

	public StatusProduct getStatusProduct() {
		return statusProduct;
	}

	public void setStatusProduct(StatusProduct statusProduct) {
		this.statusProduct = StatusProduct.SOLD;
	}

	public String getBarCodeMock() {
		return barCodeMock;
	}

	public void setBarCodeMock(String barCodeMock) {
		this.barCodeMock = barCodeMock;
	}

}
