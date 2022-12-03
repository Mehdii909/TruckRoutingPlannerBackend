package com.example.app.service.interfaces;

import com.example.app.persistance.entities.Mission;

public interface IMission {

    void saveMission(Mission mission);

    Mission getMissionById(Long id);

    void deleteMission(Long id);

    Mission updateMission(Long id, Mission mission);

}
