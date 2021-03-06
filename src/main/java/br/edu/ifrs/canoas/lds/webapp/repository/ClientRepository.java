package br.edu.ifrs.canoas.lds.webapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Client;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	Optional<Client> findByName(String name);
}
