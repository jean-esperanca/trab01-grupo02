package br.edu.ifrs.canoas.lds.webapp.controller;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.service.AdressService;
import br.edu.ifrs.canoas.lds.webapp.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

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
	private final AdressService adressService;
	
	public ClientController(Messages messages, ClientService clientService, AdressService adressService) {
		this.messages = messages;
		this.clientService = clientService;
		this.adressService = adressService;
	}
	
	@GetMapping("/list")
	public ModelAndView list(){
		//TODO RNG003 - Buscar Cliente
		ModelAndView mav = new ModelAndView("/client/list");
		mav.addObject("clients", clientService.list());
		
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id, RedirectAttributes redirectAttr){
		
		if(clientService.isExist(id)==true){
			ModelAndView mav = new ModelAndView("/client/form");
			mav.addObject("client", clientService.getId(id));
			mav.addObject("isView", true); //true = No editable fields
			return mav;
			
		}else{
			ModelAndView mav2 = new ModelAndView("redirect:/client/list");
			redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
			return mav2;
		}
		
	}
	
	@GetMapping("/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("/client/form");
		
		mav.addObject("client", new Client());
		mav.addObject("isCreate", true); //false = editable fields
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		
		
		if(clientService.isExist(id)==true){
			ModelAndView mav = new ModelAndView("/client/form");
			mav.addObject("client", clientService.getId(id));
			mav.addObject("isEdit", true); //false = editable fields
			return mav;
		}else{
			ModelAndView mav2 = new ModelAndView("redirect:/client/list");
			redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
			return mav2;
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		ModelAndView mav = new ModelAndView("redirect:/client/list");
		
		if(clientService.delete(id)==false){
			redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
		}else{
			redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
		}
		
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Client client, BindingResult bindingResult, 
            RedirectAttributes redirectAttr, Locale locale){
		
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("/client/form");
			mav.addObject("isCreate", true);
            return mav;
            
        }
		
		ModelAndView mav = new ModelAndView("redirect:/client/list");
		mav.addObject("client", clientService.save(client));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved"));
		
		return mav;
	}
}
