package com.example.app.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.persistance.dao.ClientRepository;
import com.example.app.persistance.entities.Client;
import com.example.app.service.interfaces.IClient;

@Service
public class ClientService implements IClient {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Long id, Client client) {
        Client clientdb = clientRepository.findById(id).get();
        clientdb.setAddress(client.getAddress());
        clientdb.setEmail(client.getEmail());
        clientdb.setNom(client.getNom());
        clientdb.setNumTel(client.getNumTel());
        clientRepository.save(clientdb);
        return clientdb;
    }
}
