package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Product;
import br.edu.ifrs.canoas.lds.webapp.domain.Provider;
import br.edu.ifrs.canoas.lds.webapp.repository.ProductRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ProviderRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseRepository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 *  Changed by Jean Esperança Aug/31/2017
 */
@Service
public class ProviderService {

	private final ProviderRepository providerRepository;
	private final ProductRepository productRepository;

	public ProviderService(ProviderRepository providerRepository, ProductRepository productRepository) {
		this.providerRepository = providerRepository;
		this.productRepository = productRepository;
	}

	public Iterable<Provider> list() {
		return providerRepository.findAll();
	}

	public Provider save(Provider provider) {

		return providerRepository.save(provider);
	}

	public Provider getOne(Provider provider) {
		return providerRepository.findById(provider.getId()).get();
	}

	// TODO RNG004 - ID Não Encontrado
	public boolean delete(Long id) {
		try {
			providerRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Provider getId(Long id) {
		return providerRepository.getOne(id);
	}

	public boolean isExist(Long id) {
		return providerRepository.existsById(id);
	}

	public boolean isPersistence(Long id) {
		ArrayList<Product> products = new ArrayList<>();
		products = (ArrayList<Product>) productRepository.findAll();
		
		for(Product product : products) {
			if (id == product.getProvider().getId()) {
				return true;
			}
		}
		return false;
	}
}
