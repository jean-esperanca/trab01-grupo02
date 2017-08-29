package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		ModelAndView mav = new ModelAndView("/product/list");
		mav.addObject("products", productService.findAll());
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("/product/form");
		mav.addObject("product", new Product());
        mav.addObject("categories", productService.findAllCategories());
		mav.addObject("isCreate", true);
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		ModelAndView mav = new ModelAndView("redirect:/product/list");
		productService.delete(id);
		
		redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("/client/form");
		
		mav.addObject("product", productService.getId(id));
		mav.addObject("isView", true); //true = No editable fields
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("/product/form");
		
		mav.addObject("product", productService.getId(id));
		mav.addObject("isEdit", true); //false = editable fields
		return mav;
	}
	
}


