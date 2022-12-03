package com.example.app.persistance.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mission")
public class Mission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Date dateMission;

    @Column
    private String destination;

    @Column
    private String description;

    @Column
    private Float qte;

    @Column
    private Float prixHT;

    @Column
    private Float prcentageTVA;

    @Column
    private Float prixTotale;

    @Column
    private Boolean etat;

}
