package com.example.app.service.interfaces;

import com.example.app.persistance.entities.InterventionPreventif;

public interface IInterventionPreventif {

    void saveInterventionPreventif(InterventionPreventif camion);
    InterventionPreventif getInterventionPreventifById(Long id);
    void deleteInterventionPreventif(Long id);
    InterventionPreventif updateInterventionPreventif(Long id, InterventionPreventif camion);
}
