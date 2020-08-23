package br.com.virtual.store.ws.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtual.store.ws.dto.CreateUserDTO;
import br.com.virtual.store.ws.dto.DeleteUserDTO;
import br.com.virtual.store.ws.dto.GetUserDTO;
import br.com.virtual.store.ws.dto.UpdateUserDTO;
import br.com.virtual.store.ws.entities.User;
import br.com.virtual.store.ws.enums.CreateUserEnumErrors;
import br.com.virtual.store.ws.enums.GetUserEnumErrors;
import br.com.virtual.store.ws.enums.UpdateUserEnumErrors;
import br.com.virtual.store.ws.exceptions.CreateUserException;
import br.com.virtual.store.ws.exceptions.GetUserException;
import br.com.virtual.store.ws.exceptions.UpdateUserException;
import br.com.virtual.store.ws.repository.UserRepository;
import br.com.virtual.store.ws.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(CreateUserDTO userDto) throws CreateUserException {
		checkIfUserExists(userDto);
		User entity = new User();
		BeanUtils.copyProperties(userDto, entity);
		return userRepository.save(entity);
	}

	private void checkIfUserExists(CreateUserDTO userDto) throws CreateUserException {
		User user = userRepository.findByEmail(userDto.getEmail());
		if (user.getEmail() != null) {
			throw new CreateUserException(CreateUserEnumErrors.ACCOUNT_EXISTS.message,
					CreateUserEnumErrors.ACCOUNT_EXISTS.wrongField, CreateUserEnumErrors.ACCOUNT_EXISTS.errorCode);
		}
	}

	@Override
	public void updateUser(UpdateUserDTO updateUserDto) throws UpdateUserException {
		Optional<User> entity = userRepository.findById(updateUserDto.getId());
		if (!entity.isPresent()) {
			throw new UpdateUserException(UpdateUserEnumErrors.ACCOUNT_DOES_NOT_EXIST.message,
					UpdateUserEnumErrors.ACCOUNT_DOES_NOT_EXIST.wrongField,
					UpdateUserEnumErrors.ACCOUNT_DOES_NOT_EXIST.errorCode);
		}
		User userEntity = entity.get();
		userEntity.setName(updateUserDto.getName());
		userEntity.setBirthDate(updateUserDto.getBirthDate());
		userRepository.save(userEntity);
	}

	@Override
	public void deleteUser(DeleteUserDTO deleteUserDto) {
		userRepository.deleteById(deleteUserDto.getId());
	}

	@Override
	public User getUser(GetUserDTO getUserDto) throws GetUserException {
		Optional<User> entity = userRepository.findById(getUserDto.getId());
		if (!entity.isPresent()) {
			throw new GetUserException(GetUserEnumErrors.ACCOUNT_DOES_NOT_EXIST.message,
					GetUserEnumErrors.ACCOUNT_DOES_NOT_EXIST.wrongField,
					GetUserEnumErrors.ACCOUNT_DOES_NOT_EXIST.errorCode);
		}

		return entity.get();

	}

}
