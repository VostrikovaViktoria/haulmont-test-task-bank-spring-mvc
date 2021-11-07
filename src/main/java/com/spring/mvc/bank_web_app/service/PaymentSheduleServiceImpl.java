package com.spring.mvc.bank_web_app.service;

import com.spring.mvc.bank_web_app.dao.PaymentSheduleDAO;
import com.spring.mvc.bank_web_app.entity.PaymentShedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentSheduleServiceImpl implements PaymentSheduleService{

    @Autowired
    PaymentSheduleDAO paymentSheduleDAO;

    @Override
    @Transactional
    public List<PaymentShedule> getPaymentSheduleId(UUID id) {
        return paymentSheduleDAO.getPaymentSheduleId(id);
    }

    @Override
    @Transactional
    public List<PaymentShedule> getAll() {
        return paymentSheduleDAO.getAll();
    }

    @Override
    @Transactional
    public void savePaymentShedule(List<PaymentShedule> shedules) {
        paymentSheduleDAO.savePaymentShedule(shedules);
    }

    @Override
    @Transactional
    public void deletePaymentShedule(UUID id) {
        paymentSheduleDAO.deletePaymentShedule(id);
    }
}
