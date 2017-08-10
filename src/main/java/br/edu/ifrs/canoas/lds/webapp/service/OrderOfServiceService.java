package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.OrderOfServiceRepository;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Service
public class OrderOfServiceService {

	private final OrderOfServiceRepository orderOfServiceRepository;

	public OrderOfServiceService(OrderOfServiceRepository orderOfServiceRepository) {
		this.orderOfServiceRepository = orderOfServiceRepository;
	}
	
}
