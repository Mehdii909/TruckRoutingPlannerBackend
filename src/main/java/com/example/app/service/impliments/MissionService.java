package com.example.app.service.impliments;

import com.example.app.utils.exceptions.ErrorStrings;
import com.example.app.utils.exceptions.MyInternalServerErrorException;
import com.example.app.utils.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.persistance.dao.MissionRepository;
import com.example.app.persistance.entities.Mission;
import com.example.app.service.interfaces.IMission;

import java.util.List;

@Service
public class MissionService implements IMission {

    @Autowired
    MissionRepository missionRepository;

    @Override
    public List<Mission> getAll() {
        return missionRepository.findAll();
    }

    @Override
    public void saveMission(Mission mission) {
        try {
            missionRepository.save(mission);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Mission getMissionById(Long id) {
        return missionRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.MISSION_NOT_FOUND));
    }

    public void deleteMission(Long id) {
        try {
            missionRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Mission updateMission(Long id, Mission mission) {
        Mission missiondb = missionRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.MISSION_NOT_FOUND));
        try {
            missiondb.setDateMission(mission.getDateMission());
            missiondb.setDescription(mission.getDescription());
            missiondb.setDestination(mission.getDestination());
            missiondb.setEtat(mission.getEtat());

            missionRepository.save(missiondb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return missiondb;
    }

}
