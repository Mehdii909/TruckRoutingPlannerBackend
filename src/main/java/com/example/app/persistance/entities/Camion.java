package com.example.app.persistance.entities;

import javax.persistence.*;

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

    @Column
    private Float immatriculation;

    @Column
    private Float numCarteGrise;

    @Column
    private Float kilometrage;

    // relation oneToMany with mission
    // relation manyToOne with les deux type d'intervention
}
