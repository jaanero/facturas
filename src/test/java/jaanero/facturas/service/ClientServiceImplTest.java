package jaanero.facturas.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import jaanero.facturas.model.Client;
import jaanero.facturas.model.ClientTest;
import jaanero.facturas.persistence.ClientRepository;

public class ClientServiceImplTest {
	
	
	private ClientServiceImpl clientService = null; 
	
	private ClientRepository clientRepository;
	private List<Client> clients;
	
	@Before 
	public void init(){
	   clients = Mockito.mock(List.class); 
		clientRepository = Mockito.mock(ClientRepository.class);
		Mockito.when(clientRepository.findByName(ClientTest.CLIENT_NAME)).thenReturn(ClientTest.CLIENT);
		Mockito.when(clientRepository.findByName(ClientTest.ANOTHER_CLIENT_NAME)).thenReturn(ClientTest.ANOTHER_CLIENT);
		
		Mockito.when(clientRepository.findAll()).thenReturn(clients);
		
		clientService = new ClientServiceImpl(clientRepository);
	}
	
	@Test
	public void should_create_a_clientService(){
		clientService = new ClientServiceImpl();
		Assert.assertNotNull(clientService);
	}
	
	@Test
	public void should_find_client_by_name(){
		
		Client clientInserted = clientService.findByName(ClientTest.CLIENT.getName());
		assertNotNull(clientInserted);
	}
	
	@Test
	public void should_find_two_different_clients_with_different_id(){

	
		Client clientInserted = clientService.findByName(ClientTest.CLIENT.getName());
		assertEquals(ClientTest.CLIENT.getId(), clientInserted.getId());
		
		Client anotherClientInserted = clientService.findByName(ClientTest.ANOTHER_CLIENT.getName());
		assertEquals(ClientTest.ANOTHER_CLIENT.getId(), anotherClientInserted.getId());
		
	}
	
	@Test 
	public void should_be_able_to_insert_a_client(){
		clientService.insertClient(ClientTest.CLIENT);
		Mockito.verify(clientRepository).save(ClientTest.CLIENT);
	}
	
	@Test
	public void should_be_able_to_find_all_clients(){
	   List<Client> clients = clientService.findAll();
	   
	   Assert.assertEquals(this.clients, clients);
	   
	   
	}

}
