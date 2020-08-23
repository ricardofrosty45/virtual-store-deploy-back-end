package br.com.virtual.store.ws.response;

import java.util.Date;
import java.util.List;

import br.com.virtual.store.ws.entities.Address;

public class GetUserResponse {

	private String id;

	private String email;

	private String name;

	private String documentNumber;

	private Date birthDate;

	private List<Address> userAdresses;

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

	public static class Builder {
		private String id;

		private String email;

		private String name;

		private String documentNumber;

		private Date birthDate;

		private List<Address> userAdresses;

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDocumentNumber(String documentNumber) {
			this.documentNumber = documentNumber;
			return this;
		}

		public Builder withBirthDate(Date birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder withUserAdresses(List<Address> userAdresses) {
			this.userAdresses = userAdresses;
			return this;
		}

		public GetUserResponse Build() {
			GetUserResponse response = new GetUserResponse();
			response.id = this.id;
			response.name = this.name;
			response.email = this.email;
			response.documentNumber = this.documentNumber;
			response.birthDate = this.birthDate;
			response.userAdresses = this.userAdresses;

			return response;
		}
	}

}
