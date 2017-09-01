package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Provider;
import br.edu.ifrs.canoas.lds.webapp.repository.ProviderRepository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 *  Changed by Jean Esperança Aug/31/2017
 */
@Service
public class ProviderService {

	private final ProviderRepository providerRepository;

	public ProviderService(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}
	
	public Iterable<Provider> list(){
		return providerRepository.findAll();
	}
}
