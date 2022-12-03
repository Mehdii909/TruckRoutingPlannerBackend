package com.example.app.service.impliments;

import com.example.app.persistance.dao.FicheDePaieRepository;
import com.example.app.persistance.entities.FicheDePaie;
import com.example.app.service.interfaces.IFicheDePaie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FicheDePaieService implements IFicheDePaie {
    @Autowired
    FicheDePaieRepository ficheDePaieRepository;

    @Override
    public void saveFicheDePaie(FicheDePaie ficheDePaie) {
        ficheDePaieRepository.save(ficheDePaie);
    }

    @Override
    public FicheDePaie getFicheDePaieById(Long id) {
        return  ficheDePaieRepository.findById(id).get();
    }

    @Override
    public void deleteFicheDePaie(Long id){
        ficheDePaieRepository.deleteById(id);
    }

    @Override
    public FicheDePaie updateFicheDePaie(Long id, FicheDePaie ficheDePaie){
        FicheDePaie ficheDePaiedb = ficheDePaieRepository.findById(id).get();
        ficheDePaiedb.setDateDu(ficheDePaie.getDateDu());
        ficheDePaiedb.setDateAu(ficheDePaie.getDateAu());
        ficheDePaiedb.setSalaireBrut(ficheDePaie.getSalaireBrut());
        ficheDePaiedb.setSalaireNet(ficheDePaie.getSalaireNet());
        ficheDePaiedb.setImpot(ficheDePaie.getImpot());
        ficheDePaieRepository.save(ficheDePaiedb);
        return ficheDePaiedb;
    }

}