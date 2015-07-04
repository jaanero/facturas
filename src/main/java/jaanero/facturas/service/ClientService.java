package jaanero.facturas.service;

import jaanero.facturas.model.Client;

public interface ClientService {

	void insertClient(Client client);

	Client findClient(String clientId);

}
