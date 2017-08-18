package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.domain.Order;
import br.edu.ifrs.canoas.lds.webapp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.OrderRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

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

	public Order save(Order order){
		return orderRepository.save(order);
	}

	public Order getOne(Order order){
		return orderRepository.findById(order.getId()).get();
	}

	public void delete(Long id){
		orderRepository.deleteById(id);
	}

	public Order getId(Long id){
		return orderRepository.getOne(id);
	}

	public Iterable<Order> list(){
		return orderRepository.findAll();
	}
	
}
