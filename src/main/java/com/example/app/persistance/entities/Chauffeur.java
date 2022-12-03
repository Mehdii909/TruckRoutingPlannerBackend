package com.example.app.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chauffeur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private float numTel;

    @Column
    private float numCompte;

    @Column
    private float codeCNSS;

    @Column
    private String adresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getNumTel() {
        return numTel;
    }

    public void setNumTel(float numTel) {
        this.numTel = numTel;
    }

    public float getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(float numCompte) {
        this.numCompte = numCompte;
    }

    public float getCodeCNSS() {
        return codeCNSS;
    }

    public void setCodeCNSS(float codeCNSS) {
        this.codeCNSS = codeCNSS;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
