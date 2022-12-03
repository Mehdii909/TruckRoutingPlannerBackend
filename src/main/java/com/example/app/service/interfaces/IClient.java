package com.example.app.service.interfaces;

import com.example.app.persistance.entities.Client;

public interface IClient {

    void saveClient(Client client);

    Client getClientById(Long id);

    void deleteClient(Long id);

    Client updateClient(Long id, Client client);
}
