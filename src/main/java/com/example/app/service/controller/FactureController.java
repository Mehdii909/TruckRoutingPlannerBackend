package com.example.app.service.controller;

import com.example.app.persistance.entities.Facture;
import com.example.app.service.interfaces.IFacture;
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
@RequestMapping(value = "/api/factures", produces = MediaType.APPLICATION_JSON_VALUE)
public class FactureController {


    @Autowired
    IFacture factureService;

    @PostMapping(path = "/factures", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) {
        factureService.saveFacture(facture);
        return new ResponseEntity<Facture>(facture, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAll();
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return factureService.getFactureById(id);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture facture) {
        return factureService.updateFacture(id, facture);
    }

    @DeleteMapping("/{id}")
    public void deleteFactureById(@PathVariable Long id) {
        factureService.deleteFacture(id);
    }
}
