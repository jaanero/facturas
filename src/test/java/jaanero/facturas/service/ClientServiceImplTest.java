package jaanero.facturas.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import jaanero.facturas.mapper.ClientMapper;
import jaanero.facturas.model.Client;

public class ClientServiceImplTest {
	
	private static final String CLIENT_ID = "1";
	private static final String ANOTHER_CLIENT_ID = "2";
	
	private static final Client CLIENT = Client.aClient().setId(CLIENT_ID).build();
	private static final Client ANOTHER_CLIENT = Client.aClient().setId(ANOTHER_CLIENT_ID).build();
	
	private ClientServiceImpl clientService = null;
	
	@Before 
	public void init(){
		ClientMapper clientMapper = Mockito.mock(ClientMapper.class);
		Mockito.when(clientMapper.getClient(CLIENT_ID)).thenReturn(CLIENT);
		Mockito.when(clientMapper.getClient(ANOTHER_CLIENT_ID)).thenReturn(ANOTHER_CLIENT);
		
		clientService = new ClientServiceImpl();
		clientService.setClientMapper(clientMapper);
	}
	
	@Test
	public void should_insert_client_and_find_it_by_id(){
		
		clientService.insertClient(CLIENT);
		Client clientInserted = clientService.findClient(CLIENT.getId());
		assertNotNull(clientInserted);
	}
	
	@Test
	public void should_insert_two_clients_and_should_be_able_to_find_them_by_id(){

		clientService.insertClient(CLIENT);
		clientService.insertClient(ANOTHER_CLIENT);
		
		Client clientInserted = clientService.findClient(CLIENT.getId());
		assertEquals(CLIENT.getId(), clientInserted.getId());
		
		Client anotherClientInserted = clientService.findClient(ANOTHER_CLIENT.getId());
		assertEquals(ANOTHER_CLIENT.getId(), anotherClientInserted.getId());
		
		
		
	}

}
