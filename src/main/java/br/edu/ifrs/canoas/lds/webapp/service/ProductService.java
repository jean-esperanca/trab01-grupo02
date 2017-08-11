package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.ProductRepository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
}
