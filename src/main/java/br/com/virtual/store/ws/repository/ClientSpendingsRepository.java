package br.com.virtual.store.ws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import br.com.virtual.store.ws.entities.ClientSpendings;

@Component
public interface ClientSpendingsRepository extends MongoRepository<ClientSpendings, String> {

}
