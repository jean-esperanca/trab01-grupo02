package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseRepository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Service
public class PurchaseService {

	private final PurchaseRepository purchaseRepository;

	public PurchaseService(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}

	public Purchase save(Purchase purchase){
		return purchaseRepository.save(purchase);
	}

	public Purchase getOne(Purchase purchase){
		return purchaseRepository.findById(purchase.getId()).get();
	}

	public void delete(Long id){
		purchaseRepository.deleteById(id);
	}

	public Purchase getId(Long id){
		return purchaseRepository.getOne(id);
	}

	public Iterable<Purchase> list(){
		return purchaseRepository.findAll();
	}
	
}
