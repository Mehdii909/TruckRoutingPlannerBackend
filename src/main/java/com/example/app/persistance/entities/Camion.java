package com.example.app.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float immatriculation;
    private Float numCarteGrise;
    private Float kilometrage;

    // relation oneToMany with mission
    // relation manyToOne with les deux type d'intervention

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(Float immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Float getNumCarteGrise() {
        return numCarteGrise;
    }

    public void setNumCarteGrise(Float numCarteGrise) {
        this.numCarteGrise = numCarteGrise;
    }

    public Float getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Float kilometrage) {
        this.kilometrage = kilometrage;
    }
}
