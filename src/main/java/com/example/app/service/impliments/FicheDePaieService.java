package com.example.app.service.impliments;

import com.example.app.persistance.dao.FicheDePaieRepository;
import com.example.app.persistance.entities.FicheDePaie;
import com.example.app.service.interfaces.IFicheDePaie;
import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheDePaieService implements IFicheDePaie {
    @Autowired
    FicheDePaieRepository ficheDePaieRepository;

    @Override
    public List<FicheDePaie> getAll() {
        return ficheDePaieRepository.findAll();
    }

    @Override
    public void saveFicheDePaie(FicheDePaie ficheDePaie) {
        try {
            ficheDePaieRepository.save(ficheDePaie);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public FicheDePaie getFicheDePaieById(Long id) {
        return  ficheDePaieRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.FICHE_NOT_FOUND));
    }

    @Override
    public void deleteFicheDePaie(Long id){
        try {
            ficheDePaieRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public FicheDePaie updateFicheDePaie(Long id, FicheDePaie ficheDePaie){
        FicheDePaie ficheDePaiedb = ficheDePaieRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.FICHE_NOT_FOUND));
        try {
            ficheDePaiedb.setDateDu(ficheDePaie.getDateDu());
            ficheDePaiedb.setDateAu(ficheDePaie.getDateAu());
            ficheDePaiedb.setSalaireBrut(ficheDePaie.getSalaireBrut());
            ficheDePaiedb.setSalaireNet(ficheDePaie.getSalaireNet());
            ficheDePaiedb.setImpot(ficheDePaie.getImpot());
            ficheDePaieRepository.save(ficheDePaiedb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return ficheDePaiedb;
    }

}