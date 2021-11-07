package com.spring.mvc.bank_web_app.dao;

import com.spring.mvc.bank_web_app.entity.Credit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CreditDAOImpl implements CreditDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Credit> getAllCredits() {
        Session session = sessionFactory.getCurrentSession();
        List<Credit> credits = session.createQuery("from Credit", Credit.class).getResultList();
        return credits;
    }

    @Override
    public Credit getCredit(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        Credit credit = session.get(Credit.class, id);
        return credit;
    }

    @Override
    public Credit getCredit(double rate) {
        Session session = sessionFactory.getCurrentSession();
        Credit credit = session.get(Credit.class, rate);
        return credit;
    }

    @Override
    public void saveCredit(Credit credit) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(credit);
    }


    @Override
    public void deleteCredit(Credit credit) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(credit);
    }
}
