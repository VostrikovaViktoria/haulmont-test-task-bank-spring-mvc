package com.spring.mvc.bank_web_app.service;

import com.spring.mvc.bank_web_app.dao.CreditOfferDAO;
import com.spring.mvc.bank_web_app.entity.Credit;
import com.spring.mvc.bank_web_app.entity.CreditOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CreditOfferServiceImpl implements CreditOfferService{

    @Autowired
    CreditOfferDAO creditOfferDAO;

    @Override
    @Transactional
    public List<CreditOffer> getAllCreditOffer() {
        return creditOfferDAO.getAllCreditOffer();
    }

    @Override
    @Transactional
    public void addCreditOffer(CreditOffer creditOffer) {
        creditOfferDAO.addCreditOffer(creditOffer);
    }

    @Override
    @Transactional
    public CreditOffer getCreditOffer(UUID id) {
        return creditOfferDAO.getCreditOffer(id);
    }

    @Override
    @Transactional
    public void deleteCreditOffer(CreditOffer creditOffer) {
        creditOfferDAO.deleteCreditOffer(creditOffer);
    }

}
