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

import com.example.app.persistance.dao.FactureRepository;
import com.example.app.persistance.entities.Facture;
import com.example.app.service.interfaces.IFacture;

@RestController
@Transactional
@RequestMapping("/api")
public class FactureController {

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    IFacture factureService;

    @PostMapping(path = "/factures", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) {
        factureService.saveFacture(facture);
        return new ResponseEntity<Facture>(facture, HttpStatus.CREATED);
    }

    @GetMapping("/factures")
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @GetMapping("/factures/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return factureService.getFactureById(id);
    }

    @PutMapping("/factures/{id}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture facture) {
        return factureService.updateFacture(id, facture);
    }

    @DeleteMapping("/factures/{id}")
    public void deleteFactureById(@PathVariable Long id) {
        factureService.deleteFacture(id);
    }
}
