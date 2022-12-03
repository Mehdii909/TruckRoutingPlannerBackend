package com.example.app.service.interfaces;

import com.example.app.persistance.entities.InterventionPreventif;

import java.util.List;

public interface IInterventionPreventif {
    List<InterventionPreventif> getAll();

    void saveInterventionPreventif(InterventionPreventif camion);
    InterventionPreventif getInterventionPreventifById(Long id);
    void deleteInterventionPreventif(Long id);
    InterventionPreventif updateInterventionPreventif(Long id, InterventionPreventif camion);
}
