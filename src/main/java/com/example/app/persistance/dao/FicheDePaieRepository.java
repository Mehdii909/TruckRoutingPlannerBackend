package com.example.app.persistance.dao;

import com.example.app.persistance.entities.FicheDePaie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheDePaieRepository extends JpaRepository<FicheDePaie, Long> {
}
