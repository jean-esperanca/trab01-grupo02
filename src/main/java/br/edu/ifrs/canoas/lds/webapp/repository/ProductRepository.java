package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Product;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
