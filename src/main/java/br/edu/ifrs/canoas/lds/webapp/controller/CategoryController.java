package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.CategoryService;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Controller
@RequestMapping("/category/")
public class CategoryController {

	private final Messages messages;
	private final CategoryService categoryService;
	
	public CategoryController(Messages messages, CategoryService categoryService) {
		this.messages = messages;
		this.categoryService = categoryService;
	}
	
}
