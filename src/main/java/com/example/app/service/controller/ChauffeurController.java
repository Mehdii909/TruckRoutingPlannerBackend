package com.example.app.service.controller;

import com.example.app.persistance.dao.ChauffeurRepository;
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
@RequestMapping("/api")
public class ChauffeurController {
    @Autowired
    ChauffeurRepository chauffeurRepository;

    @Autowired
    IChauffeur chauffeurService;

    @PostMapping(path="/chauffeurs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chauffeur> createChauffeur(@RequestBody Chauffeur chauffeur) {
        chauffeurService.saveChauffeur(chauffeur);
        return new ResponseEntity<Chauffeur>(chauffeur, HttpStatus.CREATED );
    }

    @GetMapping("/chauffeurs")
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurRepository.findAll();
    }

    @GetMapping("/chauffeurs/{id}")
    public Chauffeur getChauffeurById(@PathVariable Long id) {
        return chauffeurService.getChauffeurById(id);
    }

    @PutMapping("/chauffeurs/{id}")
    public Chauffeur updateChauffeur(@PathVariable Long id, @RequestBody Chauffeur chauffeur){
        return chauffeurService.updateChauffeur(id,chauffeur);
    }


    @DeleteMapping("/chauffeurs/{id}")
    public void deleteChauffeurById(@PathVariable Long id){
        chauffeurService.deleteChauffeur(id);
    }
}
