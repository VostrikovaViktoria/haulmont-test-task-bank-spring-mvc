package com.spring.mvc.bank_web_app.service;

import com.spring.mvc.bank_web_app.entity.Client;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    public List<Client> getAllClients();

    public void addClients(Client client);

    public Client getClient(UUID id);

    public void deleteClient(Client client);
}
