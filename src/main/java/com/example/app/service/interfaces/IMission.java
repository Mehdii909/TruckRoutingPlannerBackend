package com.example.app.service.interfaces;

import com.example.app.persistance.entities.Mission;

import java.util.List;

public interface IMission {

    List<Mission> getAll();

    void saveMission(Mission mission);

    Mission getMissionById(Long id);

    void deleteMission(Long id);

    Mission updateMission(Long id, Mission mission);

}
