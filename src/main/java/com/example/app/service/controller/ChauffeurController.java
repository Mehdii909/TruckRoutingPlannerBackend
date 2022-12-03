package com.example.app.service.controller;

import com.example.app.persistance.entities.Chauffeur;
import com.example.app.service.interfaces.IChauffeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "/api/chauffeurs",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ChauffeurController {

    @Autowired
    IChauffeur chauffeurService;

    @PostMapping()
    public ResponseEntity<Chauffeur> createChauffeur(@RequestBody Chauffeur chauffeur) {
        chauffeurService.saveChauffeur(chauffeur);
        return new ResponseEntity<Chauffeur>(chauffeur, HttpStatus.CREATED );
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
    public Chauffeur updateChauffeur(@PathVariable Long id, @RequestBody Chauffeur chauffeur){
        return chauffeurService.updateChauffeur(id,chauffeur);
    }


    @DeleteMapping("/{id}")
    public void deleteChauffeurById(@PathVariable Long id){
        chauffeurService.deleteChauffeur(id);
    }
}
