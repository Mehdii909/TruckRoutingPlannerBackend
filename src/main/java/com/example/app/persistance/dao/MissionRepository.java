package com.example.app.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.persistance.entities.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
