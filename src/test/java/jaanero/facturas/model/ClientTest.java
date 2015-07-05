package jaanero.facturas.model;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {
	
	public static final String CLIENT_ID = "1";
	public static final String ANOTHER_CLIENT_ID = "2";
	
	public static final String CLIENT_NAME = "Test client";
	
	public static final Client CLIENT = Client.aClient().setId(CLIENT_ID).build();
	public static final Client ANOTHER_CLIENT = Client.aClient().setId(ANOTHER_CLIENT_ID).build();


	@Test
	public void create_and_populate_client(){
		Client client = new Client();
		client.setId(CLIENT_ID);
		client.setName(CLIENT_NAME);
		
		Assert.assertEquals(client.getId(), CLIENT_ID);
		Assert.assertEquals(client.getName(), CLIENT_NAME);
	}
	
	@Test
	public void create_and_populate_client_using_builder(){
		Client client = Client.aClient().setId(CLIENT_ID).setName(CLIENT_NAME).build();
		Assert.assertNotNull(client);
		Assert.assertEquals(client.getId(), CLIENT_ID);
		Assert.assertEquals(client.getName(), CLIENT_NAME);
	}
}
