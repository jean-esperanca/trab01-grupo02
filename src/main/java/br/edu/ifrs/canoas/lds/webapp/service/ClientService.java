package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
import br.edu.ifrs.canoas.lds.webapp.repository.ClientRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseRepository;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Service
public class ClientService {

	private final ClientRepository clientRepository;
	private final PurchaseRepository purchaseRepository;

	public ClientService(ClientRepository clientRepository, PurchaseRepository purchaseRepository) {
		this.clientRepository = clientRepository;
		this.purchaseRepository = purchaseRepository;
	}

	public Client save(Client client){
		
		return clientRepository.save(client);
	}

	public Client getOne(Client client){
		return clientRepository.findById(client.getId()).get();
	}
	
	//TODO RNG004 - ID Não Encontrado
	public boolean delete(Long id){
		try {
			
			clientRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public Client getId(Long id){
		return clientRepository.getOne(id);
	}
	
	public Iterable<Client> list(){
		return clientRepository.findAll();
	}
	
	public boolean isExist(Long id){
		return clientRepository.existsById(id);
	}
	
	public boolean isPersistence(Long id){
		    //Tem que acertar esse List, pois nao ta funcionando...
		//List purchases = (List) purchaseRepository.findAll();
		
		//for(Purchase purchase : purchases){
		//	if(id == purchase.getId()){
		//		return true;
		//	} 
		//}
		
		return false;
	}
}
