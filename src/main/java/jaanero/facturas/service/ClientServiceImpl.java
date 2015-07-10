package jaanero.facturas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jaanero.facturas.model.Client;
import jaanero.facturas.persistence.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

   @Autowired
   ClientRepository clientRepository;

   public ClientServiceImpl() {
   }

   public ClientServiceImpl(ClientRepository clientRepository) {
      this.clientRepository = clientRepository;
   }

   @Override
   public void insertClient(Client client) {
      // this.clientMapper.insertClient(client);
      this.clientRepository.save(client);
   }

   @Override
   public Client findByName(String clientName) {
      return this.clientRepository.findByName(clientName);
   }

   @Override
   public List<Client> findAll() {
      return this.clientRepository.findAll();
   }

}
