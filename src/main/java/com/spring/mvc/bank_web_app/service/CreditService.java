package com.spring.mvc.bank_web_app.service;

import com.spring.mvc.bank_web_app.entity.Credit;
import com.spring.mvc.bank_web_app.entity.CreditOffer;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    public List<Credit> getAllCredits();

    public Credit getCredit(UUID id);

    public Credit getCredit(double rate);

    public void saveCredit(Credit credit);

    public void deleteCredit(Credit credit);


}
