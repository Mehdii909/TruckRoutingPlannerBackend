package com.example.app.service.interfaces;

import com.example.app.persistance.entities.Chauffeur;

import java.util.List;

public interface IChauffeur {

    List<Chauffeur> getAll();
    void saveChauffeur(Chauffeur chauffeur);
    Chauffeur getChauffeurById(Long id);
    void deleteChauffeur(Long id);
    Chauffeur updateChauffeur(Long id, Chauffeur chauffeur);

}
