
package com.example.app.persistance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @OneToMany(mappedBy = "chauffeur")
    @JsonIgnoreProperties(value = { "chauffeur", "camion", "client"  }, allowSetters = true)
    private List<Mission> listMission;

    @OneToMany(mappedBy = "chauffeur")
    private List<FicheDePaie> listFicheDePaie;

}
