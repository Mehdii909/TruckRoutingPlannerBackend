package com.example.app.service.controller;

import com.example.app.persistance.entities.InterventionPreventif;
import com.example.app.service.interfaces.IInterventionPreventif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@Transactional
@RequestMapping(value = "/api/interventionPreventifs",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class InterventionPreventifController {


    @Autowired
    IInterventionPreventif interventionPreventifService;

    @PostMapping
    public ResponseEntity<InterventionPreventif> createInterventionPreventif(@RequestBody InterventionPreventif interventionPreventif) {
        interventionPreventifService.saveInterventionPreventif(interventionPreventif);
        return new ResponseEntity<InterventionPreventif>(interventionPreventif, HttpStatus.CREATED );
    }

    @GetMapping
    public List<InterventionPreventif> getAllInterventionPreventifs() {
        return interventionPreventifService.getAll();
    }

    @GetMapping("/{id}")
    public InterventionPreventif getInterventionPreventifById(@PathVariable Long id) {
        return interventionPreventifService.getInterventionPreventifById(id);
    }

    @PutMapping("/{id}")
    public InterventionPreventif updateInterventionPreventif(@PathVariable Long id, @RequestBody InterventionPreventif interventionPreventif){
        return interventionPreventifService.updateInterventionPreventif(id,interventionPreventif);
    }


    @DeleteMapping("/{id}")
    public void deleteInterventionPreventifById(@PathVariable Long id){
        interventionPreventifService.deleteInterventionPreventif(id);
    }

}
