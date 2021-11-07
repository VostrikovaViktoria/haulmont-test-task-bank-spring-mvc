package com.spring.mvc.bank_web_app.service;

import com.spring.mvc.bank_web_app.dao.ClientDAO;
import com.spring.mvc.bank_web_app.entity.Client;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDAO clientDAO;

    @Override
    @Transactional
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    @Transactional
    public void addClients(Client client) {
        clientDAO.addClients(client);
    }

    @Override
    @Transactional
    public Client getClient(UUID id) {
        return clientDAO.getClient(id);
    }

    @Override
    @Transactional
    public void deleteClient(Client client) {
        clientDAO.deleteClient(client);
    }
}
