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
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "facture")
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Date dateFacture;

    @Column
    private Boolean etat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mission_id", referencedColumnName = "id")
    private Mission mission;
}
