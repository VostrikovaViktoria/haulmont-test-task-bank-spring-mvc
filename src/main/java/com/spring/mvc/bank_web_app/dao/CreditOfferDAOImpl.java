package com.spring.mvc.bank_web_app.dao;

import com.spring.mvc.bank_web_app.entity.CreditOffer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CreditOfferDAOImpl implements CreditOfferDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CreditOffer> getAllCreditOffer() {
        Session session = sessionFactory.getCurrentSession();
        List<CreditOffer> creditOffers = session.createQuery("from CreditOffer", CreditOffer.class).getResultList();
        return creditOffers;
    }

    @Override
    public void addCreditOffer(CreditOffer creditOffer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(creditOffer);
    }

    @Override
    public CreditOffer getCreditOffer(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        CreditOffer creditOffer = session.get(CreditOffer.class, id);
        return creditOffer;
    }

    @Override
    public void deleteCreditOffer(CreditOffer creditOffer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(creditOffer);
    }
}
