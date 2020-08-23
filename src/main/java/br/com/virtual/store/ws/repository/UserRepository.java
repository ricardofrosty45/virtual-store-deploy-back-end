package br.com.virtual.store.ws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import br.com.virtual.store.ws.entities.User;

@Component
public interface UserRepository extends MongoRepository<User, String> {

	@Query(value = "{ 'email' : ?0 }")
	User findByEmail(String email);

}
