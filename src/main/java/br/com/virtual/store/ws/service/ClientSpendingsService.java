package br.com.virtual.store.ws.service;

import java.util.List;

import br.com.virtual.store.ws.entities.ClientSpendings;
import br.com.virtual.store.ws.exceptions.ProductException;

public interface ClientSpendingsService {
	List<ClientSpendings> findAllClientsSpendings() throws Exception;

	List<ClientSpendings> findClientOutGoingByClientId(String clientId) throws Exception;

	ClientSpendings findOneOutgoingById(String id) throws Exception;
}
