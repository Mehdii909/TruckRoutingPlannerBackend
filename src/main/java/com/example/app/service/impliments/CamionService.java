package com.example.app.service.impliments;

import com.example.app.persistance.dao.CamionRepository;
import com.example.app.persistance.entities.Camion;
import com.example.app.service.interfaces.ICamion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamionService implements ICamion {

    @Autowired
    CamionRepository camionRepository;

    @Override
    public Camion saveCamion(Camion camion) {
        return camionRepository.save(camion);
    }

    @Override
    public Camion getCamion(Long id) {
        // TODO Auto-generated method stub
        return  camionRepository.findById(id).get();
    }


}
