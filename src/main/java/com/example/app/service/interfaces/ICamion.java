package com.example.app.service.interfaces;

import com.example.app.persistance.entities.Camion;

import java.util.List;

public interface ICamion {

    List<Camion> getAll();

    void saveCamion(Camion camion);
    Camion getCamionById(Long id);
    void deleteCamion(Long id);
    Camion updateCamion(Long id, Camion camion);

}
