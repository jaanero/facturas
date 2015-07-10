package jaanero.facturas.service;

import java.util.List;

import jaanero.facturas.model.Client;

public interface ClientService {

   public void insertClient(Client client);

   public Client findByName(String clientName);

   public List<Client> findAll();
}
