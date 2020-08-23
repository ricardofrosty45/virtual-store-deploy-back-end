package br.com.virtual.store.ws.enums;

public enum CreateUserEnumErrors {
	PAYLOAD_IS_NULL("Payload is null, check your request!", "createUserRequest", 100),
	NAME_IS_NULL("name is null or empty, check your request!", "name", 101),
	DOCUMENTNUMBER_IS_NULL("documentNumber is null or empty, check your request!", "documentNumber", 102),
	BIRTHDATE_IS_NULL("birthdate is null or empty, check your request!", "birthDate", 103),
	ACCOUNT_EXISTS("this account already exists", "user", 104);

	public Integer errorCode;

	public String message;

	public String wrongField;

	private CreateUserEnumErrors(String message, String wrongField, Integer errorCode) {
		this.message = message;
		this.wrongField = wrongField;
		this.errorCode = errorCode;
	}

}
