package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.ProductRepairRepository;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Service
public class ProductRepairService {

	private final ProductRepairRepository productRepairRepository;

	public ProductRepairService(ProductRepairRepository productRepairRepository) {
		this.productRepairRepository = productRepairRepository;
	}
	
}
