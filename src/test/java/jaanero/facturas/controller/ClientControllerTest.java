package jaanero.facturas.controller;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import jaanero.facturas.model.ClientTest;
import jaanero.facturas.service.ClientService;


public class ClientControllerTest {
	
	private static final String HOME = "index";
	private ClientService clientService;
	private Model model;
	
	@Before
	public void init(){
		clientService = Mockito.mock(ClientService.class);
		model = new ExtendedModelMap();

	}
	
	@Test
	public void should_create_a_clientController(){
		ClientController clientController = new ClientController();
		Assert.assertNotNull(clientController);
	}

	@Test
	public void should_run_home_and_return_index(){

		ClientController clientController = new ClientController(clientService);
		String returnValue = clientController.home(model);
		
		Assert.assertEquals(returnValue, HOME);
	}
	
	@Test
	public void should_run_home_and_set_client_on_model(){
		Mockito.when(clientService.findByName(ClientTest.CLIENT.getName())).thenReturn(ClientTest.CLIENT);
		Mockito.when(clientService.findAll()).thenReturn(ClientTest.ALL_CLIENTS);

		ClientController clientController = new ClientController(clientService);
		clientController.home(model);
		
		Assert.assertTrue(model.containsAttribute("client"));
		Assert.assertTrue(model.containsAttribute("clients"));
	}

}
