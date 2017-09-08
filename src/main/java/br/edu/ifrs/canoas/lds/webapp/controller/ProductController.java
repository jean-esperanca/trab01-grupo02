package br.edu.ifrs.canoas.lds.webapp.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Category;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
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
        mav.addObject("providers", productService.findAllProviders());
		mav.addObject("isCreate", true);
		return mav;
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		ModelAndView mav = new ModelAndView("redirect:/product/list");
		
		if(productService.isPersistence(id)==true) {
			redirectAttr.addFlashAttribute("message", messages.get("product.persistence"));
		}else {
			if(productService.delete(id)==false) {
				redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
			}else {
				redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
			}
		}

		
		return mav;
	}
	
	
	
	
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("/product/form");
		mav.addObject("categories", productService.findAllCategories());
		mav.addObject("providers", productService.findAllProviders());
		mav.addObject("product", productService.getId(id));

		mav.addObject("isView", true); //true = No editable fields
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("/product/form");
		mav.addObject("categories", productService.findAllCategories());
		mav.addObject("providers", productService.findAllProviders());
		mav.addObject("product", productService.getId(id));
		mav.addObject("isEdit", true); //false = editable fields
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Product product, BindingResult bindingResult, 
            RedirectAttributes redirectAttr, Locale locale){
		
		if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("/product/form");
			mav.addObject("categories", productService.findAllCategories());
	        mav.addObject("providers", productService.findAllProviders());	
	        mav.addObject("isCreate", true);
	        return mav;
        }

		ModelAndView mav = new ModelAndView("redirect:/product/list");
		mav.addObject("product", productService.save(product));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved"));
		
		return mav;
	}
	
}


