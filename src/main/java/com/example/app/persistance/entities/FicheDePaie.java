package com.example.app.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FicheDePaie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date dateDu;

    @Column
    private Date dateAu;

    @Column
    private float salaireBrut;

    @Column
    private float impot;

    @Column
    private float salaireNet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDu() {
        return dateDu;
    }

    public void setDateDu(Date dateDu) {
        this.dateDu = dateDu;
    }

    public Date getDateAu() {
        return dateAu;
    }

    public void setDateAu(Date dateAu) {
        this.dateAu = dateAu;
    }

    public float getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(float salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public float getImpot() {
        return impot;
    }

    public void setImpot(float impot) {
        this.impot = impot;
    }

    public float getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(float salaireNet) {
        this.salaireNet = salaireNet;
    }
}
