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

import com.example.app.persistance.entities.Mission;
import com.example.app.service.interfaces.IMission;

@RestController
@Transactional
@RequestMapping(value = "/api/missions", produces = MediaType.APPLICATION_JSON_VALUE)
public class MissionController {

    @Autowired
    IMission missionService;

    @PostMapping
    public ResponseEntity<Mission> createMission(@RequestBody Mission mission) {
        missionService.saveMission(mission);
        return new ResponseEntity<Mission>(mission, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Mission> getAllMissions() {
        return missionService.getAll();
    }

    @GetMapping("/{id}")
    public Mission getMissionById(@PathVariable Long id) {
        return missionService.getMissionById(id);
    }

    @PutMapping("/{id}")
    public Mission updateMission(@PathVariable Long id, @RequestBody Mission mission) {
        return missionService.updateMission(id, mission);
    }

    @DeleteMapping("/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionService.deleteMission(id);
    }

}
