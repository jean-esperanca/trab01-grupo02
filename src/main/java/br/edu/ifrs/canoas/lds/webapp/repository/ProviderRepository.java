package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Provider;
import br.edu.ifrs.canoas.lds.webapp.domain.Role;

/*
 *  Create by Elvis Sept/01/2017
 *  
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{

}
