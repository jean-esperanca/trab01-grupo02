package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.domain.Category;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.domain.Product;
import br.edu.ifrs.canoas.lds.webapp.domain.Provider;
import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
import br.edu.ifrs.canoas.lds.webapp.repository.CategoryRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ProductRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ProviderRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private final PurchaseRepository purchaseRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProviderRepository providerRepository, PurchaseRepository purchaseRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.providerRepository = providerRepository;
		this.purchaseRepository = purchaseRepository;
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product getId(Long id){
		return productRepository.getOne(id);
	}
	
	public boolean delete(Long id){
		try {
			productRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
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
	
	public boolean isPersistence(Long id){
		
		ArrayList<Purchase> purchases = new ArrayList<>();
		purchases = (ArrayList<Purchase>) purchaseRepository.findAll();
		
		for(Purchase purchase : purchases){
			
			if(id == purchase.getId()){
				return true;
			} 
		}
		
		return false;
	}
}
