package com.example.app.service.controller;

import com.example.app.persistance.dao.FicheDePaieRepository;
import com.example.app.persistance.entities.FicheDePaie;
import com.example.app.service.interfaces.IFicheDePaie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api")
public class FicheDePaieController {
    @Autowired
    FicheDePaieRepository ficheDePaieRepository;

    @Autowired
    IFicheDePaie ficheDePaieService;

    @PostMapping(path="/ficheDePaies",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FicheDePaie> createFicheDePaie(@RequestBody FicheDePaie ficheDePaie) {
        ficheDePaieService.saveFicheDePaie(ficheDePaie);
        return new ResponseEntity<FicheDePaie>(ficheDePaie, HttpStatus.CREATED );
    }

    @GetMapping("/ficheDePaies")
    public List<FicheDePaie> getAllFicheDePaies() {
        return ficheDePaieRepository.findAll();
    }

    @GetMapping("/ficheDePaies/{id}")
    public FicheDePaie getFicheDePaieById(@PathVariable Long id) {
        return ficheDePaieService.getFicheDePaieById(id);
    }

    @PutMapping("/ficheDePaies/{id}")
    public FicheDePaie updateFicheDePaie(@PathVariable Long id, @RequestBody FicheDePaie ficheDePaie){
        return ficheDePaieService.updateFicheDePaie(id,ficheDePaie);
    }


    @DeleteMapping("/ficheDePaies/{id}")
    public void deleteFicheDePaieById(@PathVariable Long id){
        ficheDePaieService.deleteFicheDePaie(id);
    }
}
