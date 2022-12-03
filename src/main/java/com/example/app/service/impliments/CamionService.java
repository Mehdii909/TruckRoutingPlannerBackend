package com.example.app.service.impliments;

import com.example.app.persistance.dao.CamionRepository;
import com.example.app.persistance.entities.Camion;
import com.example.app.service.interfaces.ICamion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CamionService implements ICamion {

    @Autowired
    CamionRepository camionRepository;

    @Override
    public void saveCamion(Camion camion) {
         camionRepository.save(camion);
    }

    @Override
    public Camion getCamionById(Long id) {
        return  camionRepository.findById(id).get();
    }

    public void deleteCamion(Long id){
        camionRepository.deleteById(id);
    }

    public Camion updateCamion(Long id, Camion camion){
        Camion camiondb = camionRepository.findById(id).get();
        camiondb.setImmatriculation(camion.getImmatriculation());
        camiondb.setKilometrage(camion.getKilometrage());
        camiondb.setNumCarteGrise(camion.getNumCarteGrise());
        camionRepository.save(camiondb);
        return camiondb;
    }





}
