package com.example.app.service.interfaces;

import com.example.app.persistance.entities.FicheDePaie;

import java.util.List;

public interface IFicheDePaie {
    List<FicheDePaie> getAll();

    void saveFicheDePaie(FicheDePaie ficheDePaie);
    FicheDePaie getFicheDePaieById(Long id);
    void deleteFicheDePaie(Long id);
    FicheDePaie updateFicheDePaie(Long id, FicheDePaie ficheDePaie);
}
