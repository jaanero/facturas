package jaanero.facturas.persistence;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import jaanero.facturas.config.DataSourceConfig;
import jaanero.facturas.config.JpaConfig;
import jaanero.facturas.model.Client;
import jaanero.facturas.model.ClientTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataSourceConfig.class, JpaConfig.class}, loader=AnnotationConfigContextLoader.class)
public class ClientRepositoryTest {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	public void should_clientRepository_not_be_null(){
		Assert.assertNotNull(clientRepository);
	}
	
	@Test
	public void should_insert_client_and_find_it(){
		clientRepository.save(ClientTest.CLIENT);
		Client client = clientRepository.findByName(ClientTest.CLIENT.getName());
		
		Assert.assertEquals(client.getName(), ClientTest.CLIENT.getName());
	}
	
	@Test
	public void should_insert_two_clients_and_retrieve_all(){
		clientRepository.deleteAll();
		
		clientRepository.save(ClientTest.CLIENT);
		clientRepository.save(ClientTest.ANOTHER_CLIENT);
		
		List<Client> clients = clientRepository.findAll();
		
		Assert.assertNotNull(clients);
		
		Assert.assertEquals(clients.isEmpty(), false);
		
		Assert.assertEquals(clients.size(), 2);
	}

}
