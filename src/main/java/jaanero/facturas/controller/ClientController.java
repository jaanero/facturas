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
   private ClientService clientService;

   public ClientController() {
   }

   public ClientController(ClientService clientService) {
      this.clientService = clientService;
   }

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Model model) {
      model.addAttribute("client", clientService.findByName("Javier Garcia"));
      model.addAttribute("clients", clientService.findAll());
      return "index";
   }

}
