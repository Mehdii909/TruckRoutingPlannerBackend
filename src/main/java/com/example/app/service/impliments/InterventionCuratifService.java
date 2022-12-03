package com.example.app.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.persistance.dao.InterventionCuratifRepository;
import com.example.app.persistance.entities.InterventionCuratif;
import com.example.app.service.interfaces.IInterventionCuratif;

@Service
public class InterventionCuratifService implements IInterventionCuratif {

    @Autowired
    InterventionCuratifRepository interventionCuratifRepository;

    @Override
    public void saveInterventionCuratif(InterventionCuratif interventionCuratif) {
        interventionCuratifRepository.save(interventionCuratif);
    }

    @Override
    public InterventionCuratif getInterventionCuratifById(Long id) {
        return interventionCuratifRepository.findById(id).get();
    }

    public void deleteInterventionCuratif(Long id) {
        interventionCuratifRepository.deleteById(id);
    }

    public InterventionCuratif updateInterventionCuratif(Long id, InterventionCuratif interventionCuratif) {
        InterventionCuratif interventionCuratifdb = interventionCuratifRepository.findById(id).get();
        interventionCuratifdb.setDateIntervention(interventionCuratif.getDateIntervention());
        interventionCuratifdb.setKilometrage(interventionCuratif.getKilometrage());
        interventionCuratifdb.setProchainkilometrage(interventionCuratif.getProchainkilometrage());
        interventionCuratifdb.setPieceDeRechange(interventionCuratif.getPieceDeRechange());

        interventionCuratifRepository.save(interventionCuratifdb);
        return interventionCuratifdb;
    }
}
