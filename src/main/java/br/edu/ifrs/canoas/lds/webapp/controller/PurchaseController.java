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
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/purchase/list");
        mav.addObject("purchases", purchaseService.list());

        return mav;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id, RedirectAttributes redirectAttr) {

        if (purchaseService.isExist(id) == true) {
            ModelAndView mav = new ModelAndView("/purchase/form");

            mav.addObject("purchase", purchaseService.getId(id));
            mav.addObject("clients", purchaseService.listClients());
            mav.addObject("products", purchaseService.listProducts());
            mav.addObject("allPurchaseStatus", purchaseService.listPurchaseStatus());
            mav.addObject("readOnly", true); //true = No editable fields
            mav.addObject("isView", true);
            return mav;

        } else {
            ModelAndView mav2 = new ModelAndView("redirect:/purchase/list");
            redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
            return mav2;
        }
    }

    @GetMapping("/create")
    public ModelAndView create() {

        Purchase purchase = new Purchase();
        purchase.setPurchaseDate(new Date(new java.util.Date().getTime()));

        ModelAndView mav = new ModelAndView("/purchase/form");

        mav.addObject("purchase", purchase);
        mav.addObject("clients", purchaseService.listClients());
        mav.addObject("products", purchaseService.listProducts());
        mav.addObject("allPurchaseStatus", purchaseService.getInitialPurchaseStatus());

        mav.addObject("readOnly", false); //false = editable fields
        mav.addObject("isCreate", true);
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id , RedirectAttributes redirectAttr) {
        if (purchaseService.isExist(id) == true) {
            ModelAndView mav = new ModelAndView("/purchase/form");

            mav.addObject("purchase", purchaseService.getId(id));
            mav.addObject("clients", purchaseService.listClients());
            mav.addObject("allPurchaseStatus", purchaseService.listPurchaseStatus());
            mav.addObject("products", purchaseService.listProducts());

            if (purchaseService.getId(id).getPurchaseStatus().getId() == 1) {
                mav.addObject("readOnly", false);
                mav.addObject("isEdit", true);
            } else {
                mav.addObject("readOnly", true);
                mav.addObject("isEdit", false);
            }
            return mav;

        } else {
            ModelAndView mav2 = new ModelAndView("redirect:/purchase/list");
            redirectAttr.addFlashAttribute("message", messages.get("idNotFound"));
            return mav2;
        }
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Purchase purchase, BindingResult bindingResult,
                             RedirectAttributes redirectAttr) {

        purchase.setCompletionDate(new Date(new java.util.Date().getTime()));

        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("redirect:/purchase/list");
            System.out.println(purchase.getCompletionDate());
            System.out.println(bindingResult.getAllErrors());
            System.out.println(purchase.toString());
            System.out.println("HAS ERROR >.<");
            return mav;
        }else{
            System.out.println("NO HAS ERROR, YAHOOO!!!");
        }

        ModelAndView mav = new ModelAndView("redirect:/purchase/list");
        mav.addObject("purchase", purchaseService.save(purchase));
        redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

        return mav;
    }
}