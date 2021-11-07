package com.spring.mvc.bank_web_app.controller;

import com.spring.mvc.bank_web_app.entity.Client;
import com.spring.mvc.bank_web_app.entity.CreditOffer;
import com.spring.mvc.bank_web_app.entity.PaymentShedule;
import com.spring.mvc.bank_web_app.service.ClientService;
import com.spring.mvc.bank_web_app.service.PaymentSheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/showClients")
    public String showClients(Model model){
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("allClients", clients);
        return "client-info";
    }

    @RequestMapping("/addNewClients")
    public String addNewClients(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "client-edit";
    }

    @RequestMapping("/saveNewClients")
    public String saveNewClients(@Valid @ModelAttribute("newClient")  Client client, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("client", client);
            model.addAttribute("hasErrors", result.getAllErrors());
            return "client-edit";
        }
        clientService.addClients(client);
        return "redirect:showClients";
    }

    @RequestMapping("/updateInfo")
    public String updateClients(@RequestParam("clientId") UUID id, Model model){
        Client client = clientService.getClient(id);
        model.addAttribute("client", client);
        return "client-edit";
    }

    @RequestMapping("/deleteClient")
    public String deleteClients(@RequestParam("clientId") UUID id){
        Client client = clientService.getClient(id);
        clientService.deleteClient(client);
        return "redirect:showClients";
    }

    @RequestMapping("/showCreditClient")
    public String showCreditClient(@RequestParam("clientId") UUID id, Model model){
        Client client = clientService.getClient(id);
        CreditOffer creditOffer = client.getCreditOffer();
        List<PaymentShedule> shedules = creditOffer.getSheduleList();
        Collections.sort(shedules);
        model.addAttribute("offer", creditOffer);
        model.addAttribute("shedules", shedules);
        return "show-credit-offer";
    }
}
