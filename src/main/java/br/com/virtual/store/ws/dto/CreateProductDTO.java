package br.com.virtual.store.ws.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.virtual.store.ws.enums.StatusProduct;

public class CreateProductDTO {
	private String productName;

	private BigDecimal productValue;

	private String productDescription;

	private Date createdProductDate;

	private StatusProduct statusProduct;

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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getCreatedProductDate() {
		return createdProductDate;
	}

	public void setCreatedProductDate(Date createdProductDate) {
		this.createdProductDate = createdProductDate;
	}

	public StatusProduct getStatusProduct() {
		return statusProduct;
	}

	public void setStatusProduct(StatusProduct statusProduct) {
		this.statusProduct = statusProduct;
	}

}
