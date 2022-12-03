package com.example.app.service.interfaces;

import com.example.app.persistance.entities.Camion;

public interface ICamion {

    Camion saveCamion(Camion camion);
    Camion getCamion(Long id);

}
