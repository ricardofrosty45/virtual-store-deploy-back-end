package br.com.virtual.store.ws.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.virtual.store.ws.enums.StatusProduct;

@Document(collection = "products")
public class Product {

	@Id
	private String id;

	private String productName;

	private BigDecimal productValue;

	private String productDescription;

	private StatusProduct statusProduct;

	private Date createdProductDate;

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
