package com.example.app.service.impliments;

import com.example.app.persistance.dao.InterventionPreventifRepository;
import com.example.app.persistance.entities.InterventionPreventif;
import com.example.app.service.interfaces.IInterventionPreventif;
import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionPreventifService implements IInterventionPreventif {

    @Autowired
    InterventionPreventifRepository interventionPreventifRepository;

    @Override
    public List<InterventionPreventif> getAll() {
        return interventionPreventifRepository.findAll();
    }

    @Override
    public void saveInterventionPreventif(InterventionPreventif interventionPreventif) {
        try {
            interventionPreventifRepository.save(interventionPreventif);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public InterventionPreventif getInterventionPreventifById(Long id) {
        return interventionPreventifRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.INTERVENTION_NOT_FOUND));
    }

    @Override
    public void deleteInterventionPreventif(Long id){
        try {
            interventionPreventifRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public InterventionPreventif updateInterventionPreventif(Long id, InterventionPreventif interventionPreventif){
        InterventionPreventif interventionPreventifdb = interventionPreventifRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.INTERVENTION_NOT_FOUND));
        try {
            interventionPreventifdb.setKilometrage(interventionPreventif.getKilometrage());
            interventionPreventifdb.setDateInt(interventionPreventif.getDateInt());
            interventionPreventifdb.setProchaineKm(interventionPreventif.getProchaineKm());
            interventionPreventifdb.setDescription(interventionPreventif.getDescription());
            interventionPreventifRepository.save(interventionPreventifdb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return interventionPreventifdb;
    }
}
