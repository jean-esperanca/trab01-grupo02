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
		/*
		Client fetchedClient = this.getOne(client);
		
		fetchedClient.setName(client.getName());
		fetchedClient.setLastName(client.getLastName());
		fetchedClient.setEmail(client.getEmail());
		fetchedClient.setCpf(client.getCpf());
		fetchedClient.setPhone(client.getPhone());
		
		fetchedClient.setStreet(client.getStreet());
		fetchedClient.setStreetNumber(client.getStreetNumber());
		fetchedClient.setNeighborhood(client.getNeighborhood());
		fetchedClient.setCity(client.getCity());
		fetchedClient.setState(client.getState());
		fetchedClient.setZipcode(client.getZipcode());
		*/
		return clientRepository.save(client);
	}

	public Client getOne(Client client){
		return clientRepository.findById(client.getId()).get();
	}
	
	public void delete(Long id){
		clientRepository.deleteById(id);
	}
	
	public Client getId(Long id){
		return clientRepository.getOne(id);
	}
	
	public Iterable<Client> list(){
		return clientRepository.findAll();
	}
}
