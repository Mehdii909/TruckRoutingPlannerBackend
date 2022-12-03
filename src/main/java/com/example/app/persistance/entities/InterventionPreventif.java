package com.example.app.persistance.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterventionPreventif implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date dateInt;

    @Column
    private float kilometrage;

    @Column
    private float prochaineKm;

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCamion")
    private Camion camion;

}
