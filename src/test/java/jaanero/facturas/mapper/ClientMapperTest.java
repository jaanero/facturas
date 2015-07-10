package jaanero.facturas.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import jaanero.facturas.config.DataSourceConfig;
import jaanero.facturas.config.MyBatisConfig;
import jaanero.facturas.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataSourceConfig.class, MyBatisConfig.class}, loader=AnnotationConfigContextLoader.class)
public class ClientMapperTest {
	private static final String CLIENT_NAME = "Test Name";
	private static final Client CLIENT = Client.aClient(CLIENT_NAME).build();

	@Autowired
	private ClientMapper clientMapper;

	@Test
	public void should_clientMapper_not_be_null(){
		Assert.assertNotNull(clientMapper);
	}
	
	@Test 
	public void should_insert_a_client_and_find_it(){
		clientMapper.insertClient(CLIENT);
		Client sameClient = clientMapper.findByName(CLIENT.getName());
		Assert.assertEquals(sameClient.getName(), CLIENT.getName());
	}

}
