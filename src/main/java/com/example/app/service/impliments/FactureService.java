package com.example.app.service.impliments;

import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.persistance.dao.FactureRepository;
import com.example.app.persistance.entities.Facture;
import com.example.app.service.interfaces.IFacture;

import java.util.List;

@Service
public class FactureService implements IFacture {

    @Autowired
    FactureRepository factureRepository;

    @Override
    public List<Facture> getAll() {
        return factureRepository.findAll();
    }

    @Override
    public void saveFacture(Facture facture) {
        try {
            factureRepository.save(facture);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Facture getFactureById(Long id) {
        return  factureRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.FACTURE_NOT_FOUND));
    }

    public void deleteFacture(Long id) {
        try {
            factureRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    public Facture updateFacture(Long id, Facture facture) {
        Facture facturedb = factureRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.FACTURE_NOT_FOUND));
        try {
            facturedb.setDateFacture(facture.getDateFacture());
            facturedb.setEtat(facture.getEtat());
            factureRepository.save(facturedb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return facturedb;
    }

}
