package com.example.app.service.interfaces;

import com.example.app.persistance.entities.InterventionCuratif;

import java.util.List;

public interface IInterventionCuratif {

    List<InterventionCuratif> getAll();

    void saveInterventionCuratif(InterventionCuratif interventionCuratif);

    InterventionCuratif getInterventionCuratifById(Long id);

    void deleteInterventionCuratif(Long id);

    InterventionCuratif updateInterventionCuratif(Long id, InterventionCuratif interventionCuratif);

}
