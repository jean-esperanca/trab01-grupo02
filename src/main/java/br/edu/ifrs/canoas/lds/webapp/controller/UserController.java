package br.edu.ifrs.canoas.lds.webapp.controller;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.config.auth.UserImpl;
import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.domain.Product;
import br.edu.ifrs.canoas.lds.webapp.domain.User;
import br.edu.ifrs.canoas.lds.webapp.service.UserService;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/user/")
public class UserController {

	private final Messages messages;
	private final UserService userService;

	public UserController(Messages messages, UserService userService) {
		this.messages = messages;
		this.userService = userService;
	}

	@GetMapping("profile")
	public ModelAndView viewProfile(@AuthenticationPrincipal UserImpl activeUser) {
		ModelAndView mav = new ModelAndView("/user/profile");
		mav.addObject("user", userService.getOne(activeUser.getUser()));
		return mav;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid User user, BindingResult bindingResult,  RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/user/form");
		}

		ModelAndView mav = new ModelAndView("redirect:/user/list");
		mav.addObject("myuser", userService.save(user));
		mav.addObject("roles", userService.getRoles());	
		redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

		return mav;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/user/list");
		mav.addObject("myUsers", userService.list());

		return mav;

	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id, RedirectAttributes redirectAttr) {
		ModelAndView mav = new ModelAndView("/user/form");

		mav.addObject("myuser", userService.getId(id));
		mav.addObject("roles", userService.getRoles());
		mav.addObject("isEdit", true); // false = editable fields
		mav.addObject("isVisible", false); // visible false= can't see		
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr) {
		ModelAndView mav = new ModelAndView("redirect:/user/list");
		userService.delete(id);

		redirectAttr.addFlashAttribute("message", messages.get("field.deleted"));
		return mav;
	}

	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/user/form");

		mav.addObject("myuser", userService.getId(id));
		mav.addObject("roles", userService.getRoles());   
		mav.addObject("isView", true); // true = No editable fields
		mav.addObject("editable", false);
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("/user/form");
		mav.addObject("myuser", new User());
		mav.addObject("roles", userService.getRoles());        
		mav.addObject("isCreate", true);		
		mav.addObject("isVisible", true); // visible true= can see
		return mav;
	}

}
