package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.OrderService;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Controller
@RequestMapping("/order/")
public class OrderController {

	private final Messages messages;
	private final OrderService orderService;
	
	public OrderController(Messages messages, OrderService orderService) {
		this.messages = messages;
		this.orderService = orderService;
	}
	
}
