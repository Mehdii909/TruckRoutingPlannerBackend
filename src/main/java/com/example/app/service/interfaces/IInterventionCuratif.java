package com.example.app.service.interfaces;

import com.example.app.persistance.entities.InterventionCuratif;

public interface IInterventionCuratif {

    void saveInterventionCuratif(InterventionCuratif interventionCuratif);

    InterventionCuratif getInterventionCuratifById(Long id);

    void deleteInterventionCuratif(Long id);

    InterventionCuratif updateInterventionCuratif(Long id, InterventionCuratif interventionCuratif);

}
