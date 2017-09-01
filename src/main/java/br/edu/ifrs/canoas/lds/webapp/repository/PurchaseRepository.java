package br.edu.ifrs.canoas.lds.webapp.repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
