package jaanero.facturas.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ClientTest {
	
	public static final Long CLIENT_ID = Long.valueOf(1);
	public static final Long ANOTHER_CLIENT_ID = Long.valueOf(2);
	
	public static final String CLIENT_NAME = "EXCMO. Ayuntamiento de Almería";
	public static final String CLIENT_CIF = "P-12345678-K";
	public static final String CLIENT_SUBNAME = "Biblioteca Pública de Almería";
	public static final String CLIENT_ADDRESS = "Hermanos Machado s/n";
	public static final String CLIENT_ZIPCODE = "04004";
	public static final String CLIENT_CITY = "ALMERÍA";
	public static final String CLIENT_PROVINCE = "ALMERÍA";
	
	public static final String ANOTHER_CLIENT_NAME = "ANOTHER CLIENT";

	public static final Client CLIENT = Client.aClient(CLIENT_NAME).build();
	public static final Client ANOTHER_CLIENT = Client.aClient(ANOTHER_CLIENT_NAME).build();
	
	public static List<Client> ALL_CLIENTS = new ArrayList<Client>();
	
	static {
		ALL_CLIENTS.add(CLIENT);
		ALL_CLIENTS.add(ANOTHER_CLIENT);
	}


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
		
		List<Invoice> invoices = Mockito.mock(List.class);
		
		Client client = Client.aClient(CLIENT_NAME)
				.setCIF(CLIENT_CIF)
				.setSubname(CLIENT_SUBNAME)
				.setAddress(CLIENT_ADDRESS)
				.setZipcode(CLIENT_ZIPCODE)
				.setCity(CLIENT_CITY)
				.setProvince(CLIENT_PROVINCE)
				.build();
		client.setInvoices(invoices);
		
		Assert.assertNotNull(client);
		Assert.assertNull(client.getId());
		Assert.assertEquals(client.getName(), CLIENT_NAME);
		Assert.assertEquals(client.getAddress(), CLIENT_ADDRESS);
		Assert.assertEquals(client.getCif(), CLIENT_CIF);
		Assert.assertEquals(client.getCity(), CLIENT_CITY);
		Assert.assertEquals(client.getProvince(), CLIENT_PROVINCE);
		Assert.assertEquals(client.getSubname(), CLIENT_SUBNAME);
		Assert.assertEquals(client.getZipcode(), CLIENT_ZIPCODE);
		Assert.assertEquals(client.getInvoices(), invoices);
	}
}
