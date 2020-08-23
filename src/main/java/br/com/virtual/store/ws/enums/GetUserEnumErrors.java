package br.com.virtual.store.ws.enums;

public enum GetUserEnumErrors {
	PAYLOAD_IS_NULL("Payload is null, check your request!", "getUserRequest", 107),
	ID_IS_NULL("id is null or empty, check your request!", "id", 108),
	ACCOUNT_DOES_NOT_EXIST("account does not exist! create one instead", "entity", 109);

	public Integer errorCode;

	public String message;

	public String wrongField;

	private GetUserEnumErrors(String message, String wrongField, Integer errorCode) {
		this.message = message;
		this.wrongField = wrongField;
		this.errorCode = errorCode;
	}
}
