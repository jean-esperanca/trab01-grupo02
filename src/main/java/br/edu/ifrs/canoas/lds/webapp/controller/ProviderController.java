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
import br.edu.ifrs.canoas.lds.webapp.domain.Provider;
import br.edu.ifrs.canoas.lds.webapp.service.ProviderService;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 *  Changed by Jean Esperança Aug/31/2017
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

	@GetMapping("/list")
	public ModelAndView list() {
		// TODO RGN007 - Buscar Fornecedor
		ModelAndView mav = new ModelAndView("/provider/list");
		mav.addObject("providers", providerService.list());
		return mav;
	}

	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id, RedirectAttributes redirectAttr) {
		if (providerService.isExist(id) == true) {
			ModelAndView mav = new ModelAndView("/provider/form");
			mav.addObject("provider", providerService.getId(id));
			mav.addObject("isView", true); // true = No editable fields
			return mav;
		} else {
			ModelAndView mav2 = new ModelAndView("redirect:/provider/list");
			redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
			return mav2;
		}
	}

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("/provider/form");
		mav.addObject("provider", new Provider());
		mav.addObject("isCreate", true); // false = editable fields
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id, RedirectAttributes redirectAttr) {
		if (providerService.isExist(id) == true) {
			ModelAndView mav = new ModelAndView("/provider/form");
			mav.addObject("provider", providerService.getId(id));
			mav.addObject("isEdit", true); // false = editable fields
			return mav;
		} else {
			ModelAndView mav2 = new ModelAndView("redirect:/provider/list");
			redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
			return mav2;
		}
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr) {
		ModelAndView mav = new ModelAndView("redirect:/provider/list");
		if(providerService.delete(id)==false){
			redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
		}else{
			//providerService.delete(id);
			redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
		}
		return mav;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Provider provider, BindingResult bindingResult, RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/provider/form");
		}

		ModelAndView mav = new ModelAndView("redirect:/provider/list");
		mav.addObject("provider", providerService.save(provider));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

		return mav;
	}

}
