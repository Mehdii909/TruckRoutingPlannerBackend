package com.example.app.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.persistance.dao.MissionRepository;
import com.example.app.persistance.entities.Mission;
import com.example.app.service.interfaces.IMission;

@Service
public class MissionService implements IMission {

    @Autowired
    MissionRepository missionRepository;

    @Override
    public void saveMission(Mission mission) {
        missionRepository.save(mission);
    }

    @Override
    public Mission getMissionById(Long id) {
        return missionRepository.findById(id).get();
    }

    public void deleteMission(Long id) {
        missionRepository.deleteById(id);
    }

    @Override
    public Mission updateMission(Long id, Mission mission) {
        Mission missiondb = missionRepository.findById(id).get();
        missiondb.setDateMission(mission.getDateMission());
        missiondb.setDescription(mission.getDescription());
        missiondb.setDestination(mission.getDestination());
        missiondb.setEtat(mission.getEtat());

        missionRepository.save(missiondb);
        return missiondb;
    }

}
