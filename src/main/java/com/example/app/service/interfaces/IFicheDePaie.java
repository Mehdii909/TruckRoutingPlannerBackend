package com.example.app.service.interfaces;

import com.example.app.persistance.entities.FicheDePaie;

public interface IFicheDePaie {
    void saveFicheDePaie(FicheDePaie ficheDePaie);
    FicheDePaie getFicheDePaieById(Long id);
    void deleteFicheDePaie(Long id);
    FicheDePaie updateFicheDePaie(Long id, FicheDePaie ficheDePaie);
}
