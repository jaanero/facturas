package jaanero.facturas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jaanero.facturas.service.ClientService;


@Controller
public class ClientController {
	
	@Autowired
	ClientService clientService;


	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("client",clientService.findClient("1"));
		return "index";
	}
	
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
}
