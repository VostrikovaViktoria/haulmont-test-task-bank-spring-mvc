package com.spring.mvc.bank_web_app.dao;

import com.spring.mvc.bank_web_app.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientDAO {
    public List<Client> getAllClients();

    public void addClients(Client client);

    public Client getClient(UUID id);

    public void deleteClient(Client client);
}
