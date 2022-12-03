package com.example.app.service.interfaces;

import com.example.app.persistance.entities.Facture;

public interface IFacture {

    void saveFacture(Facture facture);

    Facture getFactureById(Long id);

    void deleteFacture(Long id);

    Facture updateFacture(Long id, Facture facture);
}
