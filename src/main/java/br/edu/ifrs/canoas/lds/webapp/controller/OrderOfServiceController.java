package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.OrderOfServiceService;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Controller
@RequestMapping("/orderOfService/")
public class OrderOfServiceController {

	private final Messages messages;
	private final OrderOfServiceService orderOfServiceService;
	
	public OrderOfServiceController(Messages messages, OrderOfServiceService orderOfServiceService) {
		this.messages = messages;
		this.orderOfServiceService = orderOfServiceService;
	}
	
	
}
