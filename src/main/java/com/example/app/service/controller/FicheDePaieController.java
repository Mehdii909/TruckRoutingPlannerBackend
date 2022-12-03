package com.example.app.service.controller;

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
@RequestMapping(value = "/api/ficheDePaies",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class FicheDePaieController {

    @Autowired
    IFicheDePaie ficheDePaieService;

    @PostMapping
    public ResponseEntity<FicheDePaie> createFicheDePaie(@RequestBody FicheDePaie ficheDePaie) {
        ficheDePaieService.saveFicheDePaie(ficheDePaie);
        return new ResponseEntity<FicheDePaie>(ficheDePaie, HttpStatus.CREATED );
    }

    @GetMapping
    public List<FicheDePaie> getAllFicheDePaies() {
        return ficheDePaieService.getAll();
    }

    @GetMapping("/{id}")
    public FicheDePaie getFicheDePaieById(@PathVariable Long id) {
        return ficheDePaieService.getFicheDePaieById(id);
    }

    @PutMapping("/{id}")
    public FicheDePaie updateFicheDePaie(@PathVariable Long id, @RequestBody FicheDePaie ficheDePaie){
        return ficheDePaieService.updateFicheDePaie(id,ficheDePaie);
    }


    @DeleteMapping("/{id}")
    public void deleteFicheDePaieById(@PathVariable Long id){
        ficheDePaieService.deleteFicheDePaie(id);
    }
}
