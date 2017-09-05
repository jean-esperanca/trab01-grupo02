package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Adress;

/*
 *  Create by Edward Ramos Sep/05/2017
 *  
 */

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

}
