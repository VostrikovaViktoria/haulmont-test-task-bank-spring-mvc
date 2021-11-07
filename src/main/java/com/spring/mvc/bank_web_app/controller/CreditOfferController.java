package com.spring.mvc.bank_web_app.controller;

import com.spring.mvc.bank_web_app.myClasses.Calculation;
import com.spring.mvc.bank_web_app.myClasses.Repayments;
import com.spring.mvc.bank_web_app.entity.Client;
import com.spring.mvc.bank_web_app.entity.Credit;
import com.spring.mvc.bank_web_app.entity.CreditOffer;
import com.spring.mvc.bank_web_app.entity.PaymentShedule;
import com.spring.mvc.bank_web_app.service.ClientService;
import com.spring.mvc.bank_web_app.service.CreditOfferService;
import com.spring.mvc.bank_web_app.service.CreditService;
import com.spring.mvc.bank_web_app.service.PaymentSheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/creditRegistration")
public class CreditOfferController {

    Credit credit;
    List<PaymentShedule> shedules;

    @Autowired
    Repayments calcRep;

    @Autowired
    CreditService creditService;

    @Autowired
    ClientService clientService;

    @Autowired
    CreditOfferService creditOfferService;

    @Autowired
    PaymentSheduleService paymentSheduleService;

    @RequestMapping("/chooseOffer")
    public String chooseOffer(Model model){
        Repayments calcRepayments = new Repayments();
        model.addAttribute("calcRepayments", calcRepayments);
        return "choose-offer";
    }

    @RequestMapping("/calcRepayment")
    public String chooseOffer(@ModelAttribute("newCalculationRepayments") Repayments repayments, Model model){
        List<Credit> creditList = creditService.getAllCredits();
        credit = Calculation.getRate(creditList, repayments.getCreditAmount());
        double rate = credit.getIntersetRate();
        repayments.setIntersetRate(rate);

        double monthPayment = Calculation.calcMonthRepayment(repayments.getCreditAmount(),
                rate, repayments.getPaymentTerm());
        repayments.setMonthlyRepayment(monthPayment);

        calcRep = repayments;
        model.addAttribute("calcRepayments", repayments);
        return "choose-offer";
    }

    @RequestMapping("/createOffer")
    public String createOffer(Model model){
        Client client = new Client();
        model.addAttribute("client", client);

        double amountMonth = calcRep.getMonthlyRepayment();
        long sumCredit = calcRep.getCreditAmount();
        int term = calcRep.getPaymentTerm();
        double sum = sumCredit;
        double rate = calcRep.getIntersetRate();
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        Date datePay;
        List<PaymentShedule> shedule = new ArrayList<>();
        term *= 12;
        int j = 0;
        for (int i = 0; i < term ; i++){
            if (month + j > 12){
                year++;
                j = 0;
                month = 1;
            }
            datePay = Date.valueOf(year + "-" + (month + j) + "-" + date);
//            System.out.println("sum " + sum);
            if (sum <= amountMonth){
                amountMonth = Calculation.aroundNumber(sum, 2);
            }
            double procCredit = Calculation.calcIntersetCredit(sum, rate);
            double bodyCredit = Calculation.calcBodyCredit(amountMonth, procCredit);
            PaymentShedule shedule1 = new PaymentShedule();
            shedule1.setDatePayment(datePay);
            shedule1.setPaymentAmount(amountMonth);
            shedule1.setAmountBodyCredit(bodyCredit);
            shedule1.setAmountInterset(procCredit);
            shedule.add(shedule1);
            sum -= bodyCredit;
            j++;
        }
        shedules = shedule;
        model.addAttribute("payShedule", shedule);
        model.addAttribute("calcRep", calcRep);
        return "create-offer";
    }

    @RequestMapping("/saveOffer")
    public String saveOffer(@Valid @ModelAttribute("newClient")  Client client, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("hasErrors", result.getAllErrors());
            model.addAttribute("client", client);
            model.addAttribute("payShedule", shedules);
            model.addAttribute("calcRep", calcRep);
            return "create-offer";
        }
        CreditOffer creditOffer = new CreditOffer();
        creditOffer.setClient(client);
        creditOffer.setCredit(credit);
        creditOffer.setCreditAmount(calcRep.getCreditAmount());
        creditOffer.setSheduleList(shedules);
        creditOfferService.addCreditOffer(creditOffer);
        return "redirect:/client/showClients";
    }
}
