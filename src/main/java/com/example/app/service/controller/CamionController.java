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


import java.util.List;

import com.example.app.persistance.entities.Camion;
import com.example.app.service.interfaces.ICamion;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Transactional
@RequestMapping(value = "/api/camions", produces = MediaType.APPLICATION_JSON_VALUE)
public class CamionController {

    @Autowired
    ICamion camionService;

    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping
    public ResponseEntity<Camion> createCamion(@RequestBody Camion camion) {
        camionService.saveCamion(camion);
        return new ResponseEntity<Camion>(camion, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping
    public List<Camion> getAllCamions() {
        return camionService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/{id}")
    public Camion getCamionById(@PathVariable Long id) {
        return camionService.getCamionById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")

    @PutMapping("/{id}")
    public Camion updateCamion(@PathVariable Long id, @RequestBody Camion camion) {
        return camionService.updateCamion(id, camion);
    }

    @CrossOrigin(origins = "http://localhost:4200")

    @DeleteMapping("/{id}")
    public void deleteCamionById(@PathVariable Long id) {
        camionService.deleteCamion(id);
    }

}
