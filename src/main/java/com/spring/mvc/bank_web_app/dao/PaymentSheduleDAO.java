package com.spring.mvc.bank_web_app.dao;

import com.spring.mvc.bank_web_app.entity.Credit;
import com.spring.mvc.bank_web_app.entity.PaymentShedule;

import java.util.List;
import java.util.UUID;

public interface PaymentSheduleDAO {

    public List<PaymentShedule> getPaymentSheduleId(UUID id);

    public List<PaymentShedule> getAll();

    public void savePaymentShedule(List<PaymentShedule> shedules);

    public void deletePaymentShedule(UUID id);
}
