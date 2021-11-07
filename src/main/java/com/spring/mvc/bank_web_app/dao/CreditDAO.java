package com.spring.mvc.bank_web_app.dao;

import com.spring.mvc.bank_web_app.entity.Credit;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface CreditDAO {

    public List<Credit> getAllCredits();

    public Credit getCredit(UUID id);

    public Credit getCredit(double rate);

    public void saveCredit(Credit credit);

    public void deleteCredit(Credit credit);
}
