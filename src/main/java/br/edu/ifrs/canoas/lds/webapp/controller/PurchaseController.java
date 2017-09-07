package br.edu.ifrs.canoas.lds.webapp.controller;

import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.PurchaseService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Locale;


/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Controller
@RequestMapping("/purchase/")
public class PurchaseController {

	private final Messages messages;
	private final PurchaseService purchaseService;

	public PurchaseController(Messages messages, PurchaseService purchaseService) {
		this.messages = messages;
		this.purchaseService = purchaseService;
	}

	@GetMapping("/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("/purchase/list");
		mav.addObject("purchases", purchaseService.list());

		return mav;
	}

	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("/purchase/form");

		mav.addObject("purchase", purchaseService.getId(id));
		mav.addObject("clients", purchaseService.listClients());
		mav.addObject("products", purchaseService.listProducts());
		mav.addObject("readOnly", true); //true = No editable fields
		mav.addObject("isView", true);
		return mav;
	}

	@GetMapping("/create")
	public ModelAndView create(){

		//DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//Date today = Calendar.getInstance().getTime();
		//String date = df.format(today);
		Date date = new Date(new java.util.Date().getTime());

		Purchase purchase = new Purchase();
		purchase.setPurchaseDate(date);

		ModelAndView mav = new ModelAndView("/purchase/form");

		mav.addObject("purchase", purchase);
		mav.addObject("clients", purchaseService.listClients());
		mav.addObject("products", purchaseService.listProducts());

		mav.addObject("readOnly", false); //false = editable fields
		mav.addObject("isCreate", true);
		mav.addObject("nowDate", date);
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("/purchase/form");

		mav.addObject("purchase", purchaseService.getId(id));
		mav.addObject("clients", purchaseService.listClients());
		mav.addObject("products", purchaseService.listProducts());
		if(!purchaseService.getId(id).getPurchaseStatus().getDescription().toString().equals("EM ABERTO")){
			mav.addObject("readOnly", false); //false = editable fields
			mav.addObject("isEdit", true);
		}else {
			mav.addObject("readOnly", true); //false = editable fields
			mav.addObject("isEdit", false);
		}
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		ModelAndView mav = new ModelAndView("/purchase/list");
		purchaseService.delete(id);

		redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
		return mav;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Purchase purchase, BindingResult bindingResult,
                             RedirectAttributes redirectAttr, Locale locale){

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/purchase/list");
		}

		ModelAndView mav = new ModelAndView("redirect:/purchase/list");
		mav.addObject("purchase", purchaseService.save(purchase));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

		return mav;
	}
	
}
