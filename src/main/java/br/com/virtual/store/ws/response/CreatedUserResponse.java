package br.com.virtual.store.ws.response;

public class CreatedUserResponse {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static class Builder {
		private String id;

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public CreatedUserResponse Build() {
			CreatedUserResponse response = new CreatedUserResponse();
			response.id = this.id;
			return response;
		}
	}

}
