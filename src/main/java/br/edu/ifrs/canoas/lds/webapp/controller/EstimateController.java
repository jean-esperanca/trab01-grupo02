package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.EstimateService;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Controller
@RequestMapping("/estimate/")
public class EstimateController {

	private final Messages messages;
	private final EstimateService estimateService;
	
	public EstimateController(Messages messages, EstimateService estimateService) {
		this.messages = messages;
		this.estimateService = estimateService;
	}
	
	
}
