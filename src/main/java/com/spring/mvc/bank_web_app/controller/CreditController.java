package com.spring.mvc.bank_web_app.controller;

import com.spring.mvc.bank_web_app.entity.Credit;
import com.spring.mvc.bank_web_app.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    CreditService creditService;

    @RequestMapping("")
    public String showClients(){
        return "index";
    }

    @RequestMapping("/showCredits")
    public String showCredit(Model model){
        List<Credit> credits = creditService.getAllCredits();
        model.addAttribute("allCredits", credits);
        return "all-credit";
    }
    @RequestMapping("/addNewCredit")
    public String addNewCredit(Model model){
        Credit credit = new Credit();
        model.addAttribute("credit", credit);
        return "credit-edit";
    }

    @RequestMapping("/saveNewCredit")
    public String saveNewCredit(@Valid @ModelAttribute("NewCredit")   Credit credit, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("credit", credit);
            model.addAttribute("hasErrors", result.getAllErrors());
            return "credit-edit";
        }
        creditService.saveCredit(credit);
        return "redirect:showCredits";
    }

    @RequestMapping("/updateInfo")
    public String updateClients(@RequestParam("creditId") UUID id, Model model){
        Credit credit = creditService.getCredit(id);
        model.addAttribute("credit", credit);
        return "credit-edit";
    }

    @RequestMapping("/deleteCredit")
    public String deleteClients(@RequestParam("creditId") UUID id){
        Credit credit = creditService.getCredit(id);
        creditService.deleteCredit(credit);
        return "redirect:showCredits";
    }

}
