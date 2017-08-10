package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.ClientService;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Controller
@RequestMapping("/client/")
public class ClientController {

	private final Messages messages;
	private final ClientService clientService;
	
	public ClientController(Messages messages, ClientService clientService) {
		this.messages = messages;
		this.clientService = clientService;
	}
	
	
	
}
