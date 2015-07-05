package jaanero.facturas.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import jaanero.facturas.config.MyBatisConfigTest;
import jaanero.facturas.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MyBatisConfigTest.class, loader=AnnotationConfigContextLoader.class)
public class ClientMapperTest {
	private static final String CLIENT_ID = "1234";
	private static final String CLIENT_NAME = "Test Name";
	private static final Client CLIENT = Client.aClient().setId(CLIENT_ID).setName(CLIENT_NAME).build();

	@Autowired
	private ClientMapper clientMapper;

	@Test
	public void should_clientMapper_not_be_null(){
		Assert.assertNotNull(clientMapper);
	}
	
	@Test 
	public void should_insert_a_client_and_find_it(){
		clientMapper.insertClient(CLIENT);
		Client sameClient = clientMapper.getClient(CLIENT.getId());
		Assert.assertEquals(sameClient.getId(), CLIENT.getId());
	}

}
