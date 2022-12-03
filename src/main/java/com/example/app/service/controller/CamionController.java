package com.example.app.service.controller;

import com.example.app.persistance.entities.Camion;
import com.example.app.service.interfaces.ICamion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @PostMapping("/camions")
    public ResponseEntity<Void> createCamion(@RequestBody Camion camion) {
        Camion CreatedCamion = camionService.saveCamion(camion);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(CreatedCamion.getId()).toUri();

        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @GetMapping("/camions")
    public List<Camion> getAllCamions() {
        return camionRepository.findAll();
    }

    @GetMapping("/camion/{id}")
    public Camion getCamionById(@PathVariable Long id) {
        return camionService.getCamion(id);
    }





}
