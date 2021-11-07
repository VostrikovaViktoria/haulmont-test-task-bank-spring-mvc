package com.spring.mvc.bank_web_app.entity;

import com.spring.mvc.bank_web_app.service.ClientService;
import com.spring.mvc.bank_web_app.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bank {

    List<Client> clientList;

    List<Credit> creditList;

    public Bank() {

    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }
}
