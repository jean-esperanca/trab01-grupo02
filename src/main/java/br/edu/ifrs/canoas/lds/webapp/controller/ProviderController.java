package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.ProviderService;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Controller
@RequestMapping("/provider/")
public class ProviderController {

	private final Messages messages;
	private final ProviderService providerService;
	
	public ProviderController(Messages messages, ProviderService providerService) {
		this.messages = messages;
		this.providerService = providerService;
	}
	
}
