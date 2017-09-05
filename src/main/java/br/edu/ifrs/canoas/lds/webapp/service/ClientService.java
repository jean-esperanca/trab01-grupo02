package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.repository.ClientRepository;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Service
public class ClientService {

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
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
}
