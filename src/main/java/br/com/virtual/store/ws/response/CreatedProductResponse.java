package br.com.virtual.store.ws.response;

import java.math.BigDecimal;
import java.util.Date;

public class CreatedProductResponse {
	private String productName;

	private BigDecimal productValue;

	private String productDescription;

	private Date createdProductDate;

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

	public static class Builder {
		private String productName;

		private BigDecimal productValue;

		private String productDescription;

		private Date createdProductDate;

		public Builder withProductName(String productName) {
			this.productName = productName;
			return this;
		}

		public Builder withProductValue(BigDecimal productValue) {
			this.productValue = productValue;
			return this;
		}

		public Builder withProductDescription(String productDescription) {
			this.productDescription = productDescription;
			return this;
		}

		public Builder withCreatedProductDate(Date createdProductDate) {
			this.createdProductDate = createdProductDate;
			return this;
		}

		public CreatedProductResponse Build() {
			CreatedProductResponse response = new CreatedProductResponse();
			response.productName = this.productName;
			response.productValue = this.productValue;
			response.productDescription = this.productDescription;
			response.createdProductDate = this.createdProductDate;
			return response;
		}
	}
}
