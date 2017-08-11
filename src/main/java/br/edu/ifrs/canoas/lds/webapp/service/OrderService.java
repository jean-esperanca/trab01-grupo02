package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.OrderRepository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
}
