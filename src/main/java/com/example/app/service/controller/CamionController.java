package com.example.app.service.controller;

import com.example.app.persistance.entities.Camion;
import com.example.app.service.interfaces.ICamion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "/api/camions" , produces = MediaType.APPLICATION_JSON_VALUE)
public class CamionController {


    @Autowired
    ICamion camionService;

    @PostMapping()
    public ResponseEntity<Camion> createCamion(@RequestBody Camion camion) {
        camionService.saveCamion(camion);
        return new ResponseEntity<Camion>(camion, HttpStatus.CREATED );
    }

    @GetMapping
    public List<Camion> getAllCamions() {
        return camionService.getAll();
    }

    @GetMapping("/{id}")
    public Camion getCamionById(@PathVariable Long id) {
        return camionService.getCamionById(id);
    }

    @PutMapping("/{id}")
    public Camion updateCamion(@PathVariable Long id, @RequestBody Camion camion){
        return camionService.updateCamion(id,camion);
    }


    @DeleteMapping("/{id}")
        public void deleteCamionById(@PathVariable Long id){
          camionService.deleteCamion(id);
        }

    }







