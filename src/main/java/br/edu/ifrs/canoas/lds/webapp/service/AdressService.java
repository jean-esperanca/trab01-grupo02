package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Adress;
import br.edu.ifrs.canoas.lds.webapp.repository.AdressRepository;

@Service
public class AdressService {

	private final AdressRepository adressRepository;

	public AdressService(AdressRepository adressRepository) {
		this.adressRepository = adressRepository;
	}
	
	public Adress getOne(Adress adress){
		return adressRepository.findById(adress.getId()).get();
	}
	
	public Adress getId(Long id){
		return adressRepository.getOne(id);
	}
	
}
