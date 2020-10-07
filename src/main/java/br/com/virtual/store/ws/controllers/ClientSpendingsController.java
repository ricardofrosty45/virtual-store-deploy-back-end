package br.com.virtual.store.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtual.store.ws.entities.ClientSpendings;
import br.com.virtual.store.ws.exceptions.ProductException;
import br.com.virtual.store.ws.response.AllClientSpendingsResponse;
import br.com.virtual.store.ws.response.CreateErrorResponse;
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
			AllClientSpendingsResponse responseBody = new AllClientSpendingsResponse();
			List<ClientSpendings> allClientsSpendings = clientSpendingsService.findAllClientsSpendings();
			responseBody.setAllClientSpendings(allClientsSpendings);
			return new ResponseEntity<AllClientSpendingsResponse>(
					new AllClientSpendingsResponse.Builder().withClientSpendings(allClientsSpendings).Build(),
					HttpStatus.FOUND);
		} catch (ProductException e1) {
			return CreateErrorResponse.createResponseErrorForProduct(e1);
		} catch (Exception e2) {
			return CreateErrorResponse.createGenericResponse(e2);
		}
	}
}
