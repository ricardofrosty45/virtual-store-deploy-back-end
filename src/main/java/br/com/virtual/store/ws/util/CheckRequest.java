package br.com.virtual.store.ws.util;

import org.springframework.stereotype.Component;

import br.com.virtual.store.ws.enums.CreateUserEnumErrors;
import br.com.virtual.store.ws.enums.DeleteUserEnumErrors;
import br.com.virtual.store.ws.enums.GetUserEnumErrors;
import br.com.virtual.store.ws.enums.ProductEnumErrors;
import br.com.virtual.store.ws.enums.UpdateUserEnumErrors;
import br.com.virtual.store.ws.exceptions.CreateUserException;
import br.com.virtual.store.ws.exceptions.DeleteUserException;
import br.com.virtual.store.ws.exceptions.GetUserException;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.exceptions.UpdateUserException;
import br.com.virtual.store.ws.request.BuyProductRequest;
import br.com.virtual.store.ws.request.CreateProductRequest;
import br.com.virtual.store.ws.request.CreateUserRequest;
import br.com.virtual.store.ws.request.DeleteUserRequest;
import br.com.virtual.store.ws.request.GetUserDetailRequest;
import br.com.virtual.store.ws.request.UpdateProductRequest;
import br.com.virtual.store.ws.request.UpdateUserRequest;

@Component
public class CheckRequest {

	public void checkCreateUserRequests(CreateUserRequest createUserRequest) throws CreateUserException {

		if (createUserRequest == null) {
			throw new CreateUserException(CreateUserEnumErrors.PAYLOAD_IS_NULL.message,
					CreateUserEnumErrors.PAYLOAD_IS_NULL.wrongField, CreateUserEnumErrors.PAYLOAD_IS_NULL.errorCode);
		}

		if (createUserRequest.getName() == null) {
			throw new CreateUserException(CreateUserEnumErrors.NAME_IS_NULL.message,
					CreateUserEnumErrors.NAME_IS_NULL.wrongField, CreateUserEnumErrors.NAME_IS_NULL.errorCode);
		}

		if (createUserRequest.getName().isEmpty()) {
			throw new CreateUserException(CreateUserEnumErrors.NAME_IS_NULL.message,
					CreateUserEnumErrors.NAME_IS_NULL.wrongField, CreateUserEnumErrors.NAME_IS_NULL.errorCode);
		}

		if (createUserRequest.getDocumentNumber() == null) {
			throw new CreateUserException(CreateUserEnumErrors.DOCUMENTNUMBER_IS_NULL.message,
					CreateUserEnumErrors.DOCUMENTNUMBER_IS_NULL.wrongField,
					CreateUserEnumErrors.DOCUMENTNUMBER_IS_NULL.errorCode);
		}

		if (createUserRequest.getDocumentNumber().isEmpty()) {
			throw new CreateUserException(CreateUserEnumErrors.DOCUMENTNUMBER_IS_NULL.message,
					CreateUserEnumErrors.DOCUMENTNUMBER_IS_NULL.wrongField,
					CreateUserEnumErrors.DOCUMENTNUMBER_IS_NULL.errorCode);
		}

		if (createUserRequest.getBirthDate() == null) {
			throw new CreateUserException(CreateUserEnumErrors.BIRTHDATE_IS_NULL.message,
					CreateUserEnumErrors.BIRTHDATE_IS_NULL.wrongField,
					CreateUserEnumErrors.BIRTHDATE_IS_NULL.errorCode);
		}

	}

	public void checkUpdateUserRequests(UpdateUserRequest updateUserRequest) throws UpdateUserException {
		if (updateUserRequest == null) {
			throw new UpdateUserException(UpdateUserEnumErrors.PAYLOAD_IS_NULL.message,
					UpdateUserEnumErrors.PAYLOAD_IS_NULL.wrongField, UpdateUserEnumErrors.PAYLOAD_IS_NULL.errorCode);
		}
		if (updateUserRequest.getName() == null) {
			throw new UpdateUserException(UpdateUserEnumErrors.NAME_IS_NULL.message,
					UpdateUserEnumErrors.NAME_IS_NULL.wrongField, UpdateUserEnumErrors.NAME_IS_NULL.errorCode);
		}

		if (updateUserRequest.getName().isEmpty()) {
			throw new UpdateUserException(UpdateUserEnumErrors.NAME_IS_NULL.message,
					UpdateUserEnumErrors.NAME_IS_NULL.wrongField, UpdateUserEnumErrors.NAME_IS_NULL.errorCode);
		}

		if (updateUserRequest.getBirthDate() == null) {
			throw new UpdateUserException(UpdateUserEnumErrors.BIRTHDATE_IS_NULL.message,
					UpdateUserEnumErrors.BIRTHDATE_IS_NULL.wrongField,
					UpdateUserEnumErrors.BIRTHDATE_IS_NULL.errorCode);
		}
	}

	public void checkDeleteUserRequests(DeleteUserRequest deleteUserRequest) throws DeleteUserException {
		if (deleteUserRequest == null) {
			throw new DeleteUserException(DeleteUserEnumErrors.PAYLOAD_IS_NULL.message,
					DeleteUserEnumErrors.PAYLOAD_IS_NULL.wrongField, DeleteUserEnumErrors.PAYLOAD_IS_NULL.errorCode);
		}
		if (deleteUserRequest.getId() == null) {
			throw new DeleteUserException(DeleteUserEnumErrors.ID_IS_NULL.message,
					DeleteUserEnumErrors.ID_IS_NULL.wrongField, DeleteUserEnumErrors.ID_IS_NULL.errorCode);
		}

		if (deleteUserRequest.getId().isEmpty()) {
			throw new DeleteUserException(DeleteUserEnumErrors.ID_IS_NULL.message,
					DeleteUserEnumErrors.ID_IS_NULL.wrongField, DeleteUserEnumErrors.ID_IS_NULL.errorCode);
		}
	}

	public void checkGetUserRequests(GetUserDetailRequest getUserRequest) throws GetUserException {

		if (getUserRequest == null) {
			throw new GetUserException(GetUserEnumErrors.PAYLOAD_IS_NULL.message,
					GetUserEnumErrors.PAYLOAD_IS_NULL.wrongField, GetUserEnumErrors.PAYLOAD_IS_NULL.errorCode);
		}
		if (getUserRequest.getId() == null) {
			throw new GetUserException(GetUserEnumErrors.ID_IS_NULL.message, GetUserEnumErrors.ID_IS_NULL.wrongField,
					GetUserEnumErrors.ID_IS_NULL.errorCode);
		}

		if (getUserRequest.getId().isEmpty()) {
			throw new GetUserException(GetUserEnumErrors.ID_IS_NULL.message, GetUserEnumErrors.ID_IS_NULL.wrongField,
					GetUserEnumErrors.ID_IS_NULL.errorCode);
		}
	}

	public void checkCreateProductRequests(CreateProductRequest createProductRequest) throws ProductException {

		if (createProductRequest == null) {
			throw new ProductException(ProductEnumErrors.PAYLOAD_IS_NULL.message,
					ProductEnumErrors.PAYLOAD_IS_NULL.wrongField, ProductEnumErrors.PAYLOAD_IS_NULL.errorCode);
		}

		if (createProductRequest.getProductName() == null) {
			throw new ProductException(ProductEnumErrors.PRODUCT_NAME_IS_NULL.message,
					ProductEnumErrors.PRODUCT_NAME_IS_NULL.wrongField,
					ProductEnumErrors.PRODUCT_NAME_IS_NULL.errorCode);
		}
		if (createProductRequest.getProductName().isEmpty()) {
			throw new ProductException(ProductEnumErrors.PRODUCT_NAME_IS_NULL.message,
					ProductEnumErrors.PRODUCT_NAME_IS_NULL.wrongField,
					ProductEnumErrors.PRODUCT_NAME_IS_NULL.errorCode);
		}

		if (createProductRequest.getProductDescription() == null) {
			throw new ProductException(ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.message,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.wrongField,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.errorCode);
		}

		if (createProductRequest.getProductValue() == null) {
			throw new ProductException(ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.message,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.wrongField,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.errorCode);
		}

	}

	public void checkUpdateProductRequests(UpdateProductRequest updateProductRequests) throws ProductException {

		if (updateProductRequests == null) {
			throw new ProductException(ProductEnumErrors.PAYLOAD_IS_NULL.message,
					ProductEnumErrors.PAYLOAD_IS_NULL.wrongField, ProductEnumErrors.PAYLOAD_IS_NULL.errorCode);
		}

		if (updateProductRequests.getIdProduct() == null) {
			throw new ProductException(ProductEnumErrors.ID_IS_NULL.message, ProductEnumErrors.ID_IS_NULL.wrongField,
					ProductEnumErrors.ID_IS_NULL.errorCode);
		}
		if (updateProductRequests.getIdProduct().isEmpty()) {
			throw new ProductException(ProductEnumErrors.ID_IS_NULL.message, ProductEnumErrors.ID_IS_NULL.wrongField,
					ProductEnumErrors.ID_IS_NULL.errorCode);
		}

		if (updateProductRequests.getProductDescription() == null) {
			throw new ProductException(ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.message,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.wrongField,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.errorCode);
		}

		if (updateProductRequests.getProductDescription().isEmpty()) {
			throw new ProductException(ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.message,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.wrongField,
					ProductEnumErrors.PRODUCT_DESCRIPTION_IS_NULL.errorCode);
		}
		if (updateProductRequests.getProductName() == null) {
			throw new ProductException(ProductEnumErrors.PRODUCT_NAME_IS_NULL.message,
					ProductEnumErrors.PRODUCT_NAME_IS_NULL.wrongField,
					ProductEnumErrors.PRODUCT_NAME_IS_NULL.errorCode);
		}
	}

	public void checkBuyProductRequests(BuyProductRequest buyProductRequests) throws ProductException {

		if (buyProductRequests == null) {
			throw new ProductException(ProductEnumErrors.PAYLOAD_IS_NULL.message,
					ProductEnumErrors.PAYLOAD_IS_NULL.wrongField, ProductEnumErrors.PAYLOAD_IS_NULL.errorCode);
		}

		if (buyProductRequests.getIdProduct() == null) {
			throw new ProductException(ProductEnumErrors.ID_IS_NULL.message, ProductEnumErrors.ID_IS_NULL.wrongField,
					ProductEnumErrors.ID_IS_NULL.errorCode);
		}
		if (buyProductRequests.getIdProduct().isEmpty()) {
			throw new ProductException(ProductEnumErrors.ID_IS_NULL.message, ProductEnumErrors.ID_IS_NULL.wrongField,
					ProductEnumErrors.ID_IS_NULL.errorCode);
		}
	}

}
