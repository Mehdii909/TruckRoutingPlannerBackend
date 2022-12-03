package com.example.app.service.impliments;

import com.example.app.persistance.dao.ChauffeurRepository;
import com.example.app.persistance.entities.Chauffeur;
import com.example.app.service.interfaces.IChauffeur;
import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChauffeurService implements IChauffeur {

    @Autowired
    ChauffeurRepository chauffeurRepository;

    @Override
    public List<Chauffeur> getAll() {
        return chauffeurRepository.findAll();
    }

    @Override
    public void saveChauffeur(Chauffeur chauffeur) {
        try {
            chauffeurRepository.save(chauffeur);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Chauffeur getChauffeurById(Long id) {
        return chauffeurRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CHAUFFEUR_NOT_FOUND));
    }

    @Override
    public void deleteChauffeur(Long id) {
        try {
            chauffeurRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Chauffeur updateChauffeur(Long id, Chauffeur chauffeur) {
        Chauffeur chauffeurdb = chauffeurRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CHAUFFEUR_NOT_FOUND));
        try {
            chauffeurdb.setNom(chauffeur.getNom());
            chauffeurdb.setPrenom(chauffeur.getPrenom());
            chauffeurdb.setNumCompte(chauffeur.getNumCompte());
            chauffeurdb.setCodeCNSS(chauffeur.getCodeCNSS());
            chauffeurdb.setNumTel(chauffeur.getNumTel());
            chauffeurdb.setAdresse(chauffeur.getAdresse());
            chauffeurRepository.save(chauffeurdb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return chauffeurdb;
    }
}