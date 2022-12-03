package com.example.app.service.controller;

import com.example.app.persistance.entities.Camion;
import com.example.app.service.interfaces.ICamion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import com.example.app.persistance.dao.CamionRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Transactional
@RequestMapping("/api")
public class CamionController {

    @Autowired
    CamionRepository camionRepository;

    @Autowired
    ICamion camionService;

    @PostMapping(path="/camions",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Camion> createCamion(@RequestBody Camion camion) {
        camionService.saveCamion(camion);
        return new ResponseEntity<Camion>(camion, HttpStatus.CREATED );
    }

    @GetMapping("/camions")
    public List<Camion> getAllCamions() {
        return camionRepository.findAll();
    }

    @GetMapping("/camions/{id}")
    public Camion getCamionById(@PathVariable Long id) {
        return camionService.getCamionById(id);
    }

    @PutMapping("/camions/{id}")
    public Camion updateCamion(@PathVariable Long id, @RequestBody Camion camion){
        return camionService.updateCamion(id,camion);
    }


    @DeleteMapping("/camions/{id}")
        public void deleteCamionById(@PathVariable Long id){
          camionService.deleteCamion(id);
        }

    }







