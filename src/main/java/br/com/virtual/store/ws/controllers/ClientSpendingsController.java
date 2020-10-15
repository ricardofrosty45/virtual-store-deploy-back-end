package br.com.virtual.store.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtual.store.ws.entities.ClientSpendings;
import br.com.virtual.store.ws.request.GetOneClientOutgoingRequest;
import br.com.virtual.store.ws.request.OutgoingRequest;
import br.com.virtual.store.ws.response.AllClientSpendingsResponse;
import br.com.virtual.store.ws.response.CreateErrorResponse;
import br.com.virtual.store.ws.response.OutgoingResponse;
import br.com.virtual.store.ws.service.ClientSpendingsService;

@CrossOrigin
@RestController
@RequestMapping("/v1/spendings/")
public class ClientSpendingsController {

	@Autowired
	private ClientSpendingsService clientSpendingsService;

	@GetMapping("/all")
	public ResponseEntity<?> getAllClientSpendings() {
		try {
			List<ClientSpendings> allClientsSpendings = clientSpendingsService.findAllClientsSpendings();
			return new ResponseEntity<AllClientSpendingsResponse>(
					new AllClientSpendingsResponse.Builder().withClientSpendings(allClientsSpendings).Build(),
					HttpStatus.OK);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@GetMapping("/client")
	public ResponseEntity<?> getClientOutgoings(@RequestParam String idClient) {
		try {
			List<ClientSpendings> clientOutgoings = clientSpendingsService
					.findClientOutGoingByClientId(idClient);
			return new ResponseEntity<AllClientSpendingsResponse>(
					new AllClientSpendingsResponse.Builder().withClientSpendings(clientOutgoings).Build(),
					HttpStatus.OK);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}

	@GetMapping("/search/one")
	public ResponseEntity<?> getOneOutgoingById(@RequestParam String id) {
		try {
			ClientSpendings clientOutgoings = clientSpendingsService.findOneOutgoingById(id);
			return new ResponseEntity<OutgoingResponse>(
					new OutgoingResponse.Builder().withClientOutgoing(clientOutgoings).Build(), HttpStatus.OK);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}
}
