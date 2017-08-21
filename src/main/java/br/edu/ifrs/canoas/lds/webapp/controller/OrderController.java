package br.edu.ifrs.canoas.lds.webapp.controller;

import br.edu.ifrs.canoas.lds.webapp.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.OrderService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

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

	@GetMapping("/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("/order/list");
		//mav.addObject("orders", orderService.list());

		return mav;
	}

	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("/order/form");

		mav.addObject("order", orderService.getId(id));
		mav.addObject("readOnly", true); //true = No editable fields
		return mav;
	}

	@GetMapping("/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("/order/form");

		mav.addObject("order", new Order());
		mav.addObject("readOnly", false); //false = editable fields
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("/order/form");

		mav.addObject("order", orderService.getId(id));
		mav.addObject("readOnly", false); //false = editable fields
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		ModelAndView mav = new ModelAndView("/order/list");
		orderService.delete(id);

		redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
		return mav;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Order order, BindingResult bindingResult,
							 RedirectAttributes redirectAttr, Locale locale){

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/order/list");
		}

		ModelAndView mav = new ModelAndView("redirect:/order/list");
		mav.addObject("order", orderService.save(order));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

		return mav;
	}
	
}
