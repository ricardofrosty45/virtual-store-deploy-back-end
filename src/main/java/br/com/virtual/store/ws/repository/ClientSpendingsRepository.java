package br.com.virtual.store.ws.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import br.com.virtual.store.ws.entities.ClientSpendings;

@Component
public interface ClientSpendingsRepository extends MongoRepository<ClientSpendings, String> {
	@Query(value = "{ 'clientId' : ?0 }")
	List<ClientSpendings> findClientOutgoingById(String clientId);
}
