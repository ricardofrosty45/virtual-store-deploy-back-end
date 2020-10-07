package br.com.virtual.store.ws.response;

import java.util.List;

import br.com.virtual.store.ws.entities.ClientSpendings;

public class AllClientSpendingsResponse {
	private List<ClientSpendings> allClientSpendings;

	public List<ClientSpendings> getAllClientSpendings() {
		return allClientSpendings;
	}

	public void setAllClientSpendings(List<ClientSpendings> allClientSpendings) {
		this.allClientSpendings = allClientSpendings;
	}

	public static class Builder {
		private List<ClientSpendings> allClientSpendings;

		public Builder withClientSpendings(List<ClientSpendings> allClientSpendings) {
			this.allClientSpendings = allClientSpendings;
			return this;
		}

		public AllClientSpendingsResponse Build() {
			AllClientSpendingsResponse response = new AllClientSpendingsResponse();
			response.setAllClientSpendings(allClientSpendings);
			return response;
		}
	}

}
