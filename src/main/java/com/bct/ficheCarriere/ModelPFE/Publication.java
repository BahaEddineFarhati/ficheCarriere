package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Date date;
    private String Nom;
    private String lien;

    public Publication() {
        
    }



    @ManyToOne
    @JoinColumn(name = "Matricule", nullable = false)
    private Employe employe;


    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Publication(Date date, String nom, String lien) {
        this.date = date;
        Nom = nom;
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "ID=" + ID +
                ", date=" + date +
                ", Nom='" + Nom + '\'' +
                ", lien='" + lien + '\'' +
                '}';
    }
}
