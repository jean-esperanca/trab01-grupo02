package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
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

	public Purchase save(Purchase purchase){
		return orderRepository.save(purchase);
	}

	public Purchase getOne(Purchase purchase){
		return orderRepository.findById(purchase.getId()).get();
	}

	public void delete(Long id){
		orderRepository.deleteById(id);
	}

	public Purchase getId(Long id){
		return orderRepository.getOne(id);
	}

	public Iterable<Purchase> list(){
		return orderRepository.findAll();
	}
	
}
