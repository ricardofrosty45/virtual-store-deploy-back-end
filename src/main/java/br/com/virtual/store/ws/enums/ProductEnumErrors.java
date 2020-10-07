package br.com.virtual.store.ws.enums;

public enum ProductEnumErrors {
	PAYLOAD_IS_NULL("Payload is null, check your request!", "createProductRequest", 111),
	PRODUCT_NAME_IS_NULL("product name is null or empty, check your request!", "productName", 112),
	PRODUCT_DESCRIPTION_IS_NULL("product description is null or empty, check your request!", "productDescription", 113),
	ID_IS_NULL("id is null or empty, check your request!", "idProduct", 114),
	PRODUCT_ALREADY_BOUGHT("Someone already bought this product, try another one!", "productEntity", 115);

	public Integer errorCode;

	public String message;

	public String wrongField;

	private ProductEnumErrors(String message, String wrongField, Integer errorCode) {
		this.message = message;
		this.wrongField = wrongField;
		this.errorCode = errorCode;
	}
}
