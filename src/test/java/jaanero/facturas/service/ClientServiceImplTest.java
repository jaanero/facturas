package jaanero.facturas.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import jaanero.facturas.mapper.ClientMapper;
import jaanero.facturas.model.Client;
import jaanero.facturas.model.ClientTest;

public class ClientServiceImplTest {
	
	
	private ClientServiceImpl clientService = null; 
	
	@Before 
	public void init(){
		ClientMapper clientMapper = Mockito.mock(ClientMapper.class);
		Mockito.when(clientMapper.getClient(ClientTest.CLIENT_ID)).thenReturn(ClientTest.CLIENT);
		Mockito.when(clientMapper.getClient(ClientTest.ANOTHER_CLIENT_ID)).thenReturn(ClientTest.ANOTHER_CLIENT);
		
		clientService = new ClientServiceImpl(clientMapper);
	}
	
	@Test
	public void should_create_a_clientService(){
		clientService = new ClientServiceImpl();
		Assert.assertNotNull(clientService);
	}
	
	@Test
	public void should_find_client_by_id(){
		
		Client clientInserted = clientService.findClient(ClientTest.CLIENT.getId());
		assertNotNull(clientInserted);
	}
	
	@Test
	public void should_find_two_different_clients_with_different_id(){

	
		Client clientInserted = clientService.findClient(ClientTest.CLIENT.getId());
		assertEquals(ClientTest.CLIENT.getId(), clientInserted.getId());
		
		Client anotherClientInserted = clientService.findClient(ClientTest.ANOTHER_CLIENT.getId());
		assertEquals(ClientTest.ANOTHER_CLIENT.getId(), anotherClientInserted.getId());
		
	}
	
	@Test 
	public void should_be_able_to_insert_a_client(){
		clientService.insertClient(ClientTest.CLIENT);
	}

}
