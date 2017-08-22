package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Product;
import br.edu.ifrs.canoas.lds.webapp.service.ProductService;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

	private final Messages messages;
	private final ProductService productService;
	
	public ProductController(Messages messages, ProductService productService) {
		this.messages = messages;
		this.productService = productService;
	}
	
	@GetMapping("list")
	public ModelAndView list(){
		return new ModelAndView("/product/list");
	}
	
	@GetMapping("/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("/product/form");
		mav.addObject("product", new Product());
		mav.addObject("isCreate", true);
		return mav;
	}
	
}
