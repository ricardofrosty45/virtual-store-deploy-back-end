package br.com.virtual.store.ws.enums;

public enum DeleteUserEnumErrors {
	PAYLOAD_IS_NULL("Payload is null, check your request!", "deleteUserRequest", 107),
	ID_IS_NULL("id is null or empty, check your request!", "id", 108);

	public Integer errorCode;

	public String message;

	public String wrongField;

	private DeleteUserEnumErrors(String message, String wrongField, Integer errorCode) {
		this.message = message;
		this.wrongField = wrongField;
		this.errorCode = errorCode;
	}
}
