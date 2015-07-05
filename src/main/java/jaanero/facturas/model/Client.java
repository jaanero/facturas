package jaanero.facturas.model;

public class Client {
	

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static class ClientBuilder {

		private String id;
		private String name;

		public ClientBuilder setId(String id) {
			this.id = id;
			return this;
		}
		public ClientBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public Client build() {
			Client client = new Client();
			client.setId(this.id);
			client.setName(this.name);
			return client;
		}
	}
	
	public static ClientBuilder aClient(){
		return new ClientBuilder();
	}
	
}
