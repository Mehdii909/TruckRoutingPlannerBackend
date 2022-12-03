package com.example.app.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.persistance.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
