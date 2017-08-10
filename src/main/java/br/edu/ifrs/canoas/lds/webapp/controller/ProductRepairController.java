package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.ProductRepairService;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Controller
@RequestMapping("/productRepair/")
public class ProductRepairController {

	private final Messages messages;
	private final ProductRepairService productRepairService;
	
	public ProductRepairController(Messages messages, ProductRepairService productRepairService) {
		this.messages = messages;
		this.productRepairService = productRepairService;
	}
	
	
}
