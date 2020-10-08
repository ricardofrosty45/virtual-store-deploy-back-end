package br.com.virtual.store.ws.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtual.store.ws.entities.ClientSpendings;
import br.com.virtual.store.ws.repository.ClientSpendingsRepository;
import br.com.virtual.store.ws.service.ClientSpendingsService;

@Service
public class ClientSpendingsServiceImpl implements ClientSpendingsService {

	@Autowired
	private ClientSpendingsRepository clientSpendingsRepository;

	@Override
	public List<ClientSpendings> findAllClientsSpendings() throws Exception {
		return clientSpendingsRepository.findAll();
	}

	@Override
	public List<ClientSpendings> findClientOutGoingByClientId(String clientId) throws Exception {
		return clientSpendingsRepository.findClientOutgoingById(clientId);
	}

	@Override
	public ClientSpendings findOneOutgoingById(String id) throws Exception {
		Optional<ClientSpendings> outgoing = clientSpendingsRepository.findById(id);
		return outgoing.get();
	}

}
