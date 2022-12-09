package com.example.app.persistance.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    /*@OneToMany(mappedBy = "camion")
    private List<InterventionCuratif> listInterventionCuratif;

    @OneToMany(mappedBy = "camion")
    private List<InterventionPreventif> listInterventionPreventif;

    @OneToMany(mappedBy = "camion")
    @JsonIgnoreProperties(value = { "chauffeur", "camion", "client" }, allowSetters = true)
     private List<Mission> listMission;*/

}
