package br.edu.ifrs.canoas.lds.webapp.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.service.ClientService;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 *  Altered by Edward Ramos Aug/14/2017
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
	
	@GetMapping("/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("/client/list");
		mav.addObject("clients", clientService.list());
		
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("/client/form");
		
		mav.addObject("client", clientService.getId(id));
		mav.addObject("isView", true); //true = No editable fields
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("/client/form");
		
		mav.addObject("client", new Client());
		mav.addObject("isCreate", true); //false = editable fields
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("/client/form");
		
		mav.addObject("client", clientService.getId(id));
		mav.addObject("isEdit", true); //false = editable fields
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		ModelAndView mav = new ModelAndView("/client/list");
		clientService.delete(id);
		
		redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Client client, BindingResult bindingResult, 
            RedirectAttributes redirectAttr, Locale locale){
		
		if (bindingResult.hasErrors()) {
            return new ModelAndView("/client/list");
        }
		
		ModelAndView mav = new ModelAndView("redirect:/client/list");
		mav.addObject("client", clientService.save(client));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved"));
		
		return mav;
	}
}
