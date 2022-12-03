package com.example.app.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.persistance.dao.FactureRepository;
import com.example.app.persistance.entities.Facture;
import com.example.app.service.interfaces.IFacture;

@Service
public class FactureService implements IFacture {

    @Autowired
    FactureRepository factureRepository;

    @Override
    public void saveFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).get();
    }

    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    public Facture updateFacture(Long id, Facture facture) {
        Facture facturedb = factureRepository.findById(id).get();
        facturedb.setDateFacture(facture.getDateFacture());
        facturedb.setEtat(facture.getEtat());
        factureRepository.save(facturedb);
        return facturedb;
    }

}
