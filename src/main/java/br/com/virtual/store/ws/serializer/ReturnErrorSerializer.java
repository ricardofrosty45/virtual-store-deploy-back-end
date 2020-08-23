package br.com.virtual.store.ws.serializer;

import br.com.virtual.store.ws.exceptions.CreateUserException;
import br.com.virtual.store.ws.exceptions.DeleteUserException;
import br.com.virtual.store.ws.exceptions.GetUserException;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.exceptions.UpdateUserException;

public class ReturnErrorSerializer {

	private String message;
	private String wrongField;
	private Integer errorCode;

	public ReturnErrorSerializer() {
		super();
	}

	public ReturnErrorSerializer(String message, String wrongField, Integer errorCode) {
		this.message = message;
		this.wrongField = wrongField;
		this.errorCode = errorCode;
	}

	public ReturnErrorSerializer(CreateUserException ex) {
		this.message = ex.getMessage();
		this.wrongField = ex.getWrongField();
		this.errorCode = ex.getErrorCode();
	}

	public ReturnErrorSerializer(UpdateUserException ex) {
		this.message = ex.getMessage();
		this.wrongField = ex.getWrongField();
		this.errorCode = ex.getErrorCode();
	}

	public ReturnErrorSerializer(DeleteUserException ex) {
		this.message = ex.getMessage();
		this.wrongField = ex.getWrongField();
		this.errorCode = ex.getErrorCode();
	}

	public ReturnErrorSerializer(GetUserException ex) {
		this.message = ex.getMessage();
		this.wrongField = ex.getWrongField();
		this.errorCode = ex.getErrorCode();
	}

	public ReturnErrorSerializer(Exception ex) {
		this.message = ex.getMessage();
		this.wrongField = ex.getCause().toString();
		this.errorCode = 500;
	}

	public ReturnErrorSerializer(ProductException ex) {
		this.message = ex.getMessage();
		this.wrongField = ex.getWrongField();
		this.errorCode = ex.getErrorCode();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
