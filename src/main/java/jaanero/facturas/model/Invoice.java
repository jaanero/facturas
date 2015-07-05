package jaanero.facturas.model;

public class Invoice {

	private Client client;
	private float base;
	
	public Invoice(Client client, float base) {
		super();
		this.setClient(client);
		this.setBase(base);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}
	
}
