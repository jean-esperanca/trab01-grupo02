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
		// TODO Auto-generated method stub
		return providerRepository.existsById(id);
	}
}
