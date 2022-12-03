package com.example.app.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.persistance.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
