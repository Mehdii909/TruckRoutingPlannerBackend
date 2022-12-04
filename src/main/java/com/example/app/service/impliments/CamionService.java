package com.example.app.service.impliments;

import com.example.app.persistance.dao.CamionRepository;
import com.example.app.persistance.entities.Camion;
import com.example.app.service.interfaces.ICamion;
import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionService implements ICamion {


    @Autowired
    CamionRepository camionRepository;

    @Override
    public List<Camion> getAll() {
        return camionRepository.findAll();
    }

    @Override
    public void saveCamion(Camion camion) {
        try {
            camionRepository.save(camion);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Camion getCamionById(Long id) {
        return  camionRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CAMION_NOT_FOUND));
    }

    @Override
    public void deleteCamion(Long id){
        try {
            camionRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Camion updateCamion(Long id, Camion camion){
        Camion camiondb = camionRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CAMION_NOT_FOUND));
        try {
            camiondb.setImmatriculation(camion.getImmatriculation());
            camiondb.setKilometrage(camion.getKilometrage());
            camiondb.setNumCarteGrise(camion.getNumCarteGrise());
            camionRepository.save(camiondb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return camiondb;
    }





}
