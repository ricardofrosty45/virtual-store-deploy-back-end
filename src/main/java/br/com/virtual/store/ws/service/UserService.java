package br.com.virtual.store.ws.service;

import br.com.virtual.store.ws.dto.CreateUserDTO;
import br.com.virtual.store.ws.dto.DeleteUserDTO;
import br.com.virtual.store.ws.dto.GetUserDTO;
import br.com.virtual.store.ws.dto.UpdateUserDTO;
import br.com.virtual.store.ws.entities.User;
import br.com.virtual.store.ws.exceptions.CreateUserException;
import br.com.virtual.store.ws.exceptions.GetUserException;
import br.com.virtual.store.ws.exceptions.UpdateUserException;

public interface UserService {

	User createUser(CreateUserDTO userDto) throws CreateUserException;

	void updateUser(UpdateUserDTO updateUserDto) throws UpdateUserException;

	void deleteUser(DeleteUserDTO deleteUserDto);

	User getUser(String id) throws GetUserException;

}
