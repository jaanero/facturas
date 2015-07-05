package jaanero.facturas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jaanero.facturas.mapper.ClientMapper;
import jaanero.facturas.model.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientMapper clientMapper;
	
	public ClientServiceImpl(){}
	
	public ClientServiceImpl(ClientMapper clientMapper){
		this.clientMapper = clientMapper;
	}

	public void insertClient(Client client) {
		this.clientMapper.insertClient(client);
	}

	public Client findClient(String clientId) {
		return this.clientMapper.getClient(clientId);
	}

}
