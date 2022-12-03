package com.example.app.persistance.dao;

import com.example.app.persistance.entities.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
}
