package com.example.app.service.controller;

import com.example.app.persistance.dao.InterventionPreventifRepository;
import com.example.app.persistance.entities.InterventionPreventif;
import com.example.app.service.interfaces.IInterventionPreventif;
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
public class InterventionPreventifController {

    @Autowired
    InterventionPreventifRepository interventionPreventifRepository;

    @Autowired
    IInterventionPreventif interventionPreventifService;

    @PostMapping(path="/interventionPreventifs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InterventionPreventif> createInterventionPreventif(@RequestBody InterventionPreventif interventionPreventif) {
        interventionPreventifService.saveInterventionPreventif(interventionPreventif);
        return new ResponseEntity<InterventionPreventif>(interventionPreventif, HttpStatus.CREATED );
    }

    @GetMapping("/interventionPreventifs")
    public List<InterventionPreventif> getAllInterventionPreventifs() {
        return interventionPreventifRepository.findAll();
    }

    @GetMapping("/interventionPreventifs/{id}")
    public InterventionPreventif getInterventionPreventifById(@PathVariable Long id) {
        return interventionPreventifService.getInterventionPreventifById(id);
    }

    @PutMapping("/interventionPreventifs/{id}")
    public InterventionPreventif updateInterventionPreventif(@PathVariable Long id, @RequestBody InterventionPreventif interventionPreventif){
        return interventionPreventifService.updateInterventionPreventif(id,interventionPreventif);
    }


    @DeleteMapping("/interventionPreventifs/{id}")
    public void deleteInterventionPreventifById(@PathVariable Long id){
        interventionPreventifService.deleteInterventionPreventif(id);
    }

}
