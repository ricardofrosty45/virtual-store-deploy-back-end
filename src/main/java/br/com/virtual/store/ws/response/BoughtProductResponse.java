package br.com.virtual.store.ws.response;

public class BoughtProductResponse {
	private String barCodeMock;

	public String getBarCodeMock() {
		return barCodeMock;
	}

	public void setBarCodeMock(String barCodeMock) {
		this.barCodeMock = barCodeMock;
	}
	

	public static class Builder {
		private String barCodeMock;

		public Builder withBarCodeMock(String barCodeMock) {
			this.barCodeMock = barCodeMock;
			return this;
		}

		public BoughtProductResponse Build() {
			BoughtProductResponse response = new BoughtProductResponse();
			response.barCodeMock = this.barCodeMock;
			return response;
		}
	}
	

}
