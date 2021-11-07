package com.spring.mvc.bank_web_app.service;

import com.spring.mvc.bank_web_app.dao.CreditDAO;
import com.spring.mvc.bank_web_app.entity.Credit;
import com.spring.mvc.bank_web_app.entity.CreditOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditDAO creditDAO;

    @Override
    @Transactional
    public List<Credit> getAllCredits() {
        return creditDAO.getAllCredits();
    }

    @Override
    @Transactional
    public Credit getCredit(UUID id) {
        return creditDAO.getCredit(id);
    }

    @Override
    @Transactional
    public Credit getCredit(double rate) {
        return creditDAO.getCredit(rate);
    }

    @Override
    @Transactional
    public void saveCredit(Credit credit) {
        creditDAO.saveCredit(credit);
    }

    @Override
    @Transactional
    public void deleteCredit(Credit credit) {
        creditDAO.deleteCredit(credit);
    }
}
