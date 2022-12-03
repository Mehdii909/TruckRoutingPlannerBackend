package com.example.app.service.impliments;

import com.example.app.persistance.dao.InterventionPreventifRepository;
import com.example.app.persistance.entities.InterventionPreventif;
import com.example.app.service.interfaces.IInterventionPreventif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterventionPreventifService implements IInterventionPreventif {

    @Autowired
    InterventionPreventifRepository interventionPreventifRepository;

    @Override
    public void saveInterventionPreventif(InterventionPreventif interventionPreventif) {
        interventionPreventifRepository.save(interventionPreventif);
    }

    @Override
    public InterventionPreventif getInterventionPreventifById(Long id) {
        return  interventionPreventifRepository.findById(id).get();
    }

    @Override
    public void deleteInterventionPreventif(Long id){
        interventionPreventifRepository.deleteById(id);
    }

    @Override
    public InterventionPreventif updateInterventionPreventif(Long id, InterventionPreventif interventionPreventif){
        InterventionPreventif interventionPreventifdb = interventionPreventifRepository.findById(id).get();
        interventionPreventifdb.setKilometrage(interventionPreventif.getKilometrage());
        interventionPreventifdb.setDateInt(interventionPreventif.getDateInt());
        interventionPreventifdb.setProchaineKm(interventionPreventif.getProchaineKm());
        interventionPreventifdb.setDescription(interventionPreventif.getDescription());
        interventionPreventifRepository.save(interventionPreventifdb);
        return interventionPreventifdb;
    }
}
