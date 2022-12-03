package com.example.app.service.impliments;

import com.example.app.persistance.dao.ClientRepository;
import com.example.app.persistance.entities.Client;
import com.example.app.service.interfaces.IClient;
import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClient {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
        try {
            clientRepository.save(client);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CLINT_NOT_FOUND));
    }

    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    public Client updateClient(Long id, Client client) {
        Client clientdb =  clientRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CLINT_NOT_FOUND));
        try {
            clientdb.setAddress(client.getAddress());
            clientdb.setEmail(client.getEmail());
            clientdb.setNom(client.getNom());
            clientdb.setNumTel(client.getNumTel());
            clientRepository.save(clientdb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return clientdb;
    }
}
