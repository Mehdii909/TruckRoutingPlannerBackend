package com.example.app.persistance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mission")
public class Mission  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Float pourcentageTVA;

    @Column
    private Float prixTotale;

    @Column
    private Boolean etat;

    @ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
    @JoinColumn(name = "id_camion")
    private Camion camion;

    @ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_chauffeur")
    private Chauffeur chauffeur;



    @ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_client")
    private Client client;

}
