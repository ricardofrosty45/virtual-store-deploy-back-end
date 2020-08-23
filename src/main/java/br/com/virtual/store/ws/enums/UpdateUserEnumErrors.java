package br.com.virtual.store.ws.enums;

public enum UpdateUserEnumErrors {
	PAYLOAD_IS_NULL("Payload is null, check your request!", "updateCreateUserRequest", 104),
	NAME_IS_NULL("name is null or empty, check your request!", "name", 105),
	BIRTHDATE_IS_NULL("birthdate is null or empty, check your request!", "birthDate", 106),
	ACCOUNT_DOES_NOT_EXIST("account does not exist! create one instead", "entity", 107);

	public Integer errorCode;

	public String message;

	public String wrongField;

	private UpdateUserEnumErrors(String message, String wrongField, Integer errorCode) {
		this.message = message;
		this.wrongField = wrongField;
		this.errorCode = errorCode;
	}
}
