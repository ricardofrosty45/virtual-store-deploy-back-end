package br.com.virtual.store.ws.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private String id;

	private String email;

	private String name;

	private String documentNumber;

	private Date birthDate;

	private List<Address> userAdresses;

	private BigDecimal clientSpendings;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getUserAdresses() {
		return userAdresses;
	}

	public void setUserAdresses(List<Address> userAdresses) {
		this.userAdresses = userAdresses;
	}

	public BigDecimal getClientSpendings() {
		return clientSpendings;
	}

	public void setClientSpendings(BigDecimal clientSpendings) {
		this.clientSpendings = clientSpendings;
	}
}
