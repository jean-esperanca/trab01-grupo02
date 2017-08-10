package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.EstimateRepository;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Service
public class EstimateService {

	private final EstimateRepository estimateRepository;

	public EstimateService(EstimateRepository estimateRepository) {
		this.estimateRepository = estimateRepository;
	}
	
}
