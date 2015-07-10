package jaanero.facturas.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import jaanero.facturas.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

   Client findByName(String clientName);

}
