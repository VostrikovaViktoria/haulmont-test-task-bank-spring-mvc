package com.spring.mvc.bank_web_app.service;

import com.spring.mvc.bank_web_app.entity.CreditOffer;

import java.util.List;
import java.util.UUID;

public interface CreditOfferService {
    public List<CreditOffer> getAllCreditOffer();

    public void addCreditOffer(CreditOffer creditOffer);

    public CreditOffer getCreditOffer(UUID id);

    public void deleteCreditOffer(CreditOffer creditOffer);
}
