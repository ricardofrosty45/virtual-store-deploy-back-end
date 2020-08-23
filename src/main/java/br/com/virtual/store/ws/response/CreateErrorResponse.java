package br.com.virtual.store.ws.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.virtual.store.ws.exceptions.CreateUserException;
import br.com.virtual.store.ws.exceptions.DeleteUserException;
import br.com.virtual.store.ws.exceptions.GetUserException;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.exceptions.UpdateUserException;
import br.com.virtual.store.ws.serializer.ReturnErrorSerializer;

public class CreateErrorResponse {

	public static ResponseEntity<?> createResponseErrorForCreatedUser(CreateUserException exception) {
		return new ResponseEntity<ReturnErrorSerializer>(new ReturnErrorSerializer(exception), HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<?> createResponseErrorForProduct(ProductException exception) {
		return new ResponseEntity<ReturnErrorSerializer>(new ReturnErrorSerializer(exception), HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<?> createResponseErrorForUpdateUser(UpdateUserException exception) {
		return new ResponseEntity<ReturnErrorSerializer>(new ReturnErrorSerializer(exception), HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<?> createResponseErrorForDeletedUser(DeleteUserException exception) {
		return new ResponseEntity<ReturnErrorSerializer>(new ReturnErrorSerializer(exception), HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<?> createResponseErrorForGetUser(GetUserException exception) {
		return new ResponseEntity<ReturnErrorSerializer>(new ReturnErrorSerializer(exception),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<?> createGenericResponse(Exception exception) {
		return new ResponseEntity<ReturnErrorSerializer>(new ReturnErrorSerializer(exception),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
