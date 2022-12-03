package com.example.app.service.impliments;

import com.example.app.persistance.dao.ChauffeurRepository;
import com.example.app.persistance.entities.Chauffeur;
import com.example.app.service.interfaces.IChauffeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChauffeurService implements IChauffeur {

    @Autowired
    ChauffeurRepository chauffeurRepository;

    @Override
    public void saveChauffeur(Chauffeur chauffeur) {
        chauffeurRepository.save(chauffeur);
    }

    @Override
    public Chauffeur getChauffeurById(Long id) {
        return chauffeurRepository.findById(id).get();
    }

    @Override
    public void deleteChauffeur(Long id) {
        chauffeurRepository.deleteById(id);
    }

    @Override
    public Chauffeur updateChauffeur(Long id, Chauffeur chauffeur) {
        Chauffeur chauffeurdb = chauffeurRepository.findById(id).get();
        chauffeurdb.setNom(chauffeur.getNom());
        chauffeurdb.setPrenom(chauffeur.getPrenom());
        chauffeurdb.setNumCompte(chauffeur.getNumCompte());
        chauffeurdb.setCodeCNSS(chauffeur.getCodeCNSS());
        chauffeurdb.setNumTel(chauffeur.getNumTel());
        chauffeurdb.setAdresse(chauffeur.getAdresse());
        chauffeurRepository.save(chauffeurdb);
        return chauffeurdb;
    }
}