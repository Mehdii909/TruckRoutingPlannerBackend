package com.example.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.persistance.dao.InterventionCuratifRepository;
import com.example.app.persistance.entities.InterventionCuratif;
import com.example.app.service.interfaces.IInterventionCuratif;

@RestController
@Transactional
@RequestMapping("/api")
public class InterventionCuratifController {

    @Autowired
    InterventionCuratifRepository interventionCuratifRepository;

    @Autowired
    IInterventionCuratif interventionCuratifService;

    @PostMapping(path = "/interventionCuratifs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InterventionCuratif> createInterventionCuratif(@RequestBody InterventionCuratif interventionCuratif) {
        interventionCuratifService.saveInterventionCuratif(interventionCuratif);
        return new ResponseEntity<InterventionCuratif>(interventionCuratif, HttpStatus.CREATED);
    }

    @GetMapping("/interventionCuratifs")
    public List<InterventionCuratif> getAllInterventionCuratifs() {
        return interventionCuratifRepository.findAll();
    }

    @GetMapping("/interventionCuratifs/{id}")
    public InterventionCuratif getInterventionCuratifById(@PathVariable Long id) {
        return interventionCuratifService.getInterventionCuratifById(id);
    }

    @PutMapping("/interventionCuratifs/{id}")
    public InterventionCuratif updateInterventionCuratif(@PathVariable Long id,
            @RequestBody InterventionCuratif interventionCuratif) {
        return interventionCuratifService.updateInterventionCuratif(id, interventionCuratif);
    }

    @DeleteMapping("/interventionCuratifs/{id}")
    public void deleteInterventionCuratifById(@PathVariable Long id) {
        interventionCuratifService.deleteInterventionCuratif(id);
    }

}
