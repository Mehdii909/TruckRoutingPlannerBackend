package com.example.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.persistance.entities.Chauffeur;
import com.example.app.service.interfaces.IChauffeur;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@Transactional
@RequestMapping(value = "/api/chauffeurs", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChauffeurController {

    @Autowired
    IChauffeur chauffeurService;

    @PostMapping()
    public ResponseEntity<Chauffeur> createChauffeur(@RequestBody Chauffeur chauffeur) {
        chauffeurService.saveChauffeur(chauffeur);
        return new ResponseEntity<Chauffeur>(chauffeur, HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurService.getAll();
    }

    @GetMapping("/{id}")
    public Chauffeur getChauffeurById(@PathVariable Long id) {
        return chauffeurService.getChauffeurById(id);
    }

    @PutMapping("/{id}")
    public Chauffeur updateChauffeur(@PathVariable Long id, @RequestBody Chauffeur chauffeur) {
        return chauffeurService.updateChauffeur(id, chauffeur);
    }

    @DeleteMapping("/{id}")
    public void deleteChauffeurById(@PathVariable Long id) {
        chauffeurService.deleteChauffeur(id);
    }
}
