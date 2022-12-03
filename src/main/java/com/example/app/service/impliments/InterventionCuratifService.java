package com.example.app.service.impliments;

import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.persistance.dao.InterventionCuratifRepository;
import com.example.app.persistance.entities.InterventionCuratif;
import com.example.app.service.interfaces.IInterventionCuratif;

import java.util.List;

@Service
public class InterventionCuratifService implements IInterventionCuratif {

    @Autowired
    InterventionCuratifRepository interventionCuratifRepository;

    @Override
    public List<InterventionCuratif> getAll() {
        return interventionCuratifRepository.findAll();
    }

    @Override
    public void saveInterventionCuratif(InterventionCuratif interventionCuratif) {
        try {
            interventionCuratifRepository.save(interventionCuratif);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public InterventionCuratif getInterventionCuratifById(Long id) {
        return interventionCuratifRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.INTERVENTION_NOT_FOUND));
    }

    public void deleteInterventionCuratif(Long id) {
        try {
            interventionCuratifRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    public InterventionCuratif updateInterventionCuratif(Long id, InterventionCuratif interventionCuratif) {
        InterventionCuratif interventionCuratifdb = interventionCuratifRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.INTERVENTION_NOT_FOUND));
        try {
            interventionCuratifdb.setDateIntervention(interventionCuratif.getDateIntervention());
            interventionCuratifdb.setKilometrage(interventionCuratif.getKilometrage());
            interventionCuratifdb.setProchainkilometrage(interventionCuratif.getProchainkilometrage());
            interventionCuratifdb.setPieceDeRechange(interventionCuratif.getPieceDeRechange());

            interventionCuratifRepository.save(interventionCuratifdb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return interventionCuratifdb;
    }
}
