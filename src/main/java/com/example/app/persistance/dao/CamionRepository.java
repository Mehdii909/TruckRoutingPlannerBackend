package com.example.app.persistance.dao;

import com.example.app.persistance.entities.Camion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamionRepository extends JpaRepository<Camion, Long> {

}
