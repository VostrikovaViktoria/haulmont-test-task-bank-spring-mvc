package com.spring.mvc.bank_web_app.dao;

import com.spring.mvc.bank_web_app.entity.Credit;
import com.spring.mvc.bank_web_app.entity.PaymentShedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PaymentSheduleDAOImpl implements PaymentSheduleDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<PaymentShedule> getPaymentSheduleId(UUID idShedules) {
        Session session = sessionFactory.getCurrentSession();
        List<PaymentShedule> shedules =  session.createQuery("from PaymentShedule where id= :idShedules",
                PaymentShedule.class).setParameter("idShedules", idShedules).getResultList();
        return shedules;
    }



    @Override
    public List<PaymentShedule> getAll(){
        Session session = sessionFactory.getCurrentSession();
        List<PaymentShedule> shedules =  session.createQuery("from PaymentShedule", PaymentShedule.class).getResultList();
        return shedules;
    }

    @Override
    public void savePaymentShedule(List<PaymentShedule> shedules) {
        Session session = sessionFactory.getCurrentSession();
        for (PaymentShedule sh: shedules) {
            session.save(sh);
        }
    }

    @Override
    public void deletePaymentShedule(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        Query<PaymentShedule> query = session.createQuery("delete from PaymentShedule where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
