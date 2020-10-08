package br.com.virtual.store.ws.response;

import br.com.virtual.store.ws.entities.ClientSpendings;

public class OutgoingResponse {
	private ClientSpendings outgoing;

	public ClientSpendings getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(ClientSpendings outgoing) {
		this.outgoing = outgoing;
	}

	public static class Builder {
		private ClientSpendings outgoing;

		public Builder withClientOutgoing(ClientSpendings outgoing) {
			this.outgoing = outgoing;
			return this;
		}

		public OutgoingResponse Build() {
			OutgoingResponse response = new OutgoingResponse();
			response.setOutgoing(outgoing);
			return response;
		}
	}

}
