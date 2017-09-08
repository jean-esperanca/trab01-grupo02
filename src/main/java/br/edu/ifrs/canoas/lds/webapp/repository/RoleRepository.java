package br.edu.ifrs.canoas.lds.webapp.repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 *  Changed by Jean Esperança Set/01/2017
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
