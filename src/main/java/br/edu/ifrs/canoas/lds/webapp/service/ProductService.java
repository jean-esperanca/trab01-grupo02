package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.domain.Product;
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
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product getId(Long id){
		return productRepository.getOne(id);
	}
	
	public void delete(Long id){
		productRepository.deleteById(id);
	}
	
	public Product getOne(Product product){
		return productRepository.findById(product.getId()).get();
	}

}
