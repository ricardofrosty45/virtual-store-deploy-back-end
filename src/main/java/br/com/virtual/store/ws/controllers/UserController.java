package br.com.virtual.store.ws.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtual.store.ws.dto.CreateUserDTO;
import br.com.virtual.store.ws.dto.DeleteUserDTO;
import br.com.virtual.store.ws.dto.GetUserDTO;
import br.com.virtual.store.ws.dto.UpdateUserDTO;
import br.com.virtual.store.ws.entities.User;
import br.com.virtual.store.ws.exceptions.CreateUserException;
import br.com.virtual.store.ws.exceptions.DeleteUserException;
import br.com.virtual.store.ws.exceptions.GetUserException;
import br.com.virtual.store.ws.exceptions.UpdateUserException;
import br.com.virtual.store.ws.request.CreateUserRequest;
import br.com.virtual.store.ws.request.DeleteUserRequest;
import br.com.virtual.store.ws.request.GetUserDetailRequest;
import br.com.virtual.store.ws.request.UpdateUserRequest;
import br.com.virtual.store.ws.response.CreateErrorResponse;
import br.com.virtual.store.ws.response.CreatedUserResponse;
import br.com.virtual.store.ws.response.GetUserResponse;
import br.com.virtual.store.ws.service.UserService;
import br.com.virtual.store.ws.service.impl.UserServiceImpl;
import br.com.virtual.store.ws.util.CheckRequest;

@CrossOrigin
@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService createUserService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequestParameter) {
		try {
			new CheckRequest().checkCreateUserRequests(createUserRequestParameter);
			CreateUserDTO createUserRequestDto = new CreateUserDTO();
			BeanUtils.copyProperties(createUserRequestParameter, createUserRequestDto);
			User user = createUserService.createUser(createUserRequestDto);
			return new ResponseEntity<CreatedUserResponse>(
					new CreatedUserResponse.Builder().withId(user.getId()).Build(), HttpStatus.CREATED);
		} catch (CreateUserException e1) {
			return CreateErrorResponse.createResponseErrorForCreatedUser(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateUserDetails(@RequestBody UpdateUserRequest updateUserRequestParameter) {
		try {
			new CheckRequest().checkUpdateUserRequests(updateUserRequestParameter);
			UpdateUserDTO updateUserRequestDto = new UpdateUserDTO();
			BeanUtils.copyProperties(updateUserRequestParameter, updateUserRequestDto);
			createUserService.updateUser(updateUserRequestDto);
			return new ResponseEntity<String>("User Updated!", HttpStatus.OK);
		} catch (UpdateUserException e1) {
			return CreateErrorResponse.createResponseErrorForUpdateUser(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteUserDetails(@RequestBody DeleteUserRequest deleteUserRequestParameter) {
		try {
			new CheckRequest().checkDeleteUserRequests(deleteUserRequestParameter);
			DeleteUserDTO deleteUserRequestDto = new DeleteUserDTO();
			BeanUtils.copyProperties(deleteUserRequestParameter, deleteUserRequestDto);
			createUserService.deleteUser(deleteUserRequestDto);
			return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
		} catch (DeleteUserException e1) {
			return CreateErrorResponse.createResponseErrorForDeletedUser(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getUserDetails(@RequestBody GetUserDetailRequest getUserRequestParameter) {
		try {
			new CheckRequest().checkGetUserRequests(getUserRequestParameter);
			GetUserDTO getUserRequestDto = new GetUserDTO();
			BeanUtils.copyProperties(getUserRequestParameter, getUserRequestDto);
			User user = createUserService.getUser(getUserRequestDto);
			return new ResponseEntity<GetUserResponse>(
					new GetUserResponse.Builder().withUserAdresses(user.getUserAdresses()).withName(user.getName())
							.withId(user.getId()).withDocumentNumber(user.getDocumentNumber())
							.withBirthDate(user.getBirthDate()).withEmail(user.getEmail()).Build(),
					HttpStatus.OK);
		} catch (GetUserException e1) {
			return CreateErrorResponse.createResponseErrorForGetUser(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}
}
