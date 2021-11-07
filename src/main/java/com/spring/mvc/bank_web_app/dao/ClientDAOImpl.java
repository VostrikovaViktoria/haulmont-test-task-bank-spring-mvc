package com.spring.mvc.bank_web_app.dao;

import com.spring.mvc.bank_web_app.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public class ClientDAOImpl implements ClientDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addClients(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
    }

    @Override
    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> allClients = session.createQuery("from Client",
                Client.class).getResultList();
        return allClients;
    }

    @Override
    public Client getClient(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class, id);
        return client;
    }

    @Override
    public void deleteClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(client);
    }
}
