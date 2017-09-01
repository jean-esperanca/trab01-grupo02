package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.domain.Category;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.domain.Product;
import br.edu.ifrs.canoas.lds.webapp.domain.Provider;
import br.edu.ifrs.canoas.lds.webapp.repository.CategoryRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ProductRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ProviderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Service
public class ProductService {

	private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProviderRepository providerRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProviderRepository providerRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.providerRepository = providerRepository;
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

    public List<Category> findAllCategories() {
	    return categoryRepository.findAll();
    }
    
    public List<Provider> findAllProviders(){
    	return providerRepository.findAll();
    }
    
	public Product save(Product product){
		return productRepository.save(product);
	}
}
