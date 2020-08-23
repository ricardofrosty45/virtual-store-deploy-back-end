package br.com.virtual.store.ws.exceptions;

public class DeleteUserException extends Exception {
	private String wrongField;

	private Integer errorCode;

	public DeleteUserException(String message, String wrongField, Integer errorCode) {
		super(message);
		this.wrongField = wrongField;
		this.errorCode = errorCode;

	}

	public String getWrongField() {
		return wrongField;
	}

	public void setWrongField(String wrongField) {
		this.wrongField = wrongField;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
