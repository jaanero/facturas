package jaanero.facturas.service;

import org.springframework.stereotype.Component;

import jaanero.facturas.mapper.ClientMapper;
import jaanero.facturas.model.Client;

@Component
public class ClientServiceImpl implements ClientService {
	
	private ClientMapper clientMapper;

	public void insertClient(Client client) {
		
		
	}

	public Client findClient(String clientId) {
		return this.clientMapper.getClient(clientId);
	}

	public ClientMapper getClientMapper() {
		return clientMapper;
	}


	public void setClientMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

}
