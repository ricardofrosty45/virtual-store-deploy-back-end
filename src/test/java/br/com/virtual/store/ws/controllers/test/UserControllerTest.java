package br.com.virtual.store.ws.controllers.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import br.com.virtual.store.ws.controllers.UserController;
import br.com.virtual.store.ws.entities.Address;
import br.com.virtual.store.ws.entities.User;
import br.com.virtual.store.ws.exceptions.CreateUserException;
import br.com.virtual.store.ws.request.CreateUserRequest;
import br.com.virtual.store.ws.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	private UserService createUserService;

	@InjectMocks
	private UserController userControler;

	@Test
	public void createUserGoodPath() throws CreateUserException {
		CreateUserRequest request = createRequest();
		User createdUser = createUser();
		Mockito.when(createUserService.createUser(Mockito.any())).thenReturn(createdUser);
		ResponseEntity<?> response = userControler.createUser(request);
		assertNotNull(response);
	}

	@Test
	public void createUserUserNotCreated() throws CreateUserException {
		CreateUserRequest request = createRequest();
		Mockito.when(createUserService.createUser(Mockito.any())).thenThrow(CreateUserException.class);
		ResponseEntity<?> response = userControler.createUser(request);
		assertNotNull(response);
	}

	@Test
	public void createUserUserUnknownError() throws CreateUserException {
		CreateUserRequest request = createRequest();
		Mockito.when(createUserService.createUser(Mockito.any())).thenReturn(null);
		ResponseEntity<?> response = userControler.createUser(request);
		assertNotNull(response);
	}

	private User createUser() {
		User userCreated = new User();
		userCreated.setBirthDate(new Date());
		userCreated.setDocumentNumber("10821107445");
		userCreated.setEmail("luan_ricardo2@hotmail.com");
		userCreated.setUserAdresses(new ArrayList<Address>());
		userCreated.setName("Luan");

		return userCreated;
	}

	private CreateUserRequest createRequest() {
		CreateUserRequest createUserRequestParameter = new CreateUserRequest();
		createUserRequestParameter.setBirthDate(new Date());
		createUserRequestParameter.setDocumentNumber("10821107445");
		createUserRequestParameter.setEmail("luan_ricardo2@hotmail.com");
		createUserRequestParameter.setUserAdresses(new ArrayList<Address>());
		createUserRequestParameter.setName("Luan");

		return createUserRequestParameter;
	}
}
