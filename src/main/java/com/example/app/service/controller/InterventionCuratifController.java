package com.example.app.service.controller;

import com.example.app.persistance.entities.InterventionCuratif;
import com.example.app.service.interfaces.IInterventionCuratif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "/api/interventionCuratifs", produces = MediaType.APPLICATION_JSON_VALUE)
public class InterventionCuratifController {

    @Autowired
    IInterventionCuratif interventionCuratifService;

    @PostMapping
    public ResponseEntity<InterventionCuratif> createInterventionCuratif(@RequestBody InterventionCuratif interventionCuratif) {
        interventionCuratifService.saveInterventionCuratif(interventionCuratif);
        return new ResponseEntity<InterventionCuratif>(interventionCuratif, HttpStatus.CREATED);
    }

    @GetMapping
    public List<InterventionCuratif> getAllInterventionCuratifs() {
        return interventionCuratifService.getAll();
    }

    @GetMapping("/{id}")
    public InterventionCuratif getInterventionCuratifById(@PathVariable Long id) {
        return interventionCuratifService.getInterventionCuratifById(id);
    }

    @PutMapping("/{id}")
    public InterventionCuratif updateInterventionCuratif(@PathVariable Long id,
            @RequestBody InterventionCuratif interventionCuratif) {
        return interventionCuratifService.updateInterventionCuratif(id, interventionCuratif);
    }

    @DeleteMapping("/{id}")
    public void deleteInterventionCuratifById(@PathVariable Long id) {
        interventionCuratifService.deleteInterventionCuratif(id);
    }

}
