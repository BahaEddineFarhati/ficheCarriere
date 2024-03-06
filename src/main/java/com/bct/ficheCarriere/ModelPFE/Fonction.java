package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Fonction")
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long ID;
     private Date Date;
     private String Nom;

    public Fonction() {

    }


    @ManyToMany(mappedBy = "Fonctions")
    private Set<Employe> employees = new HashSet<>();





    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Fonction(java.util.Date date, String nom) {
        Date = date;
        Nom = nom;
    }

    @Override
    public String toString() {
        return "Fonction{" +
                "ID=" + ID +
                ", Date=" + Date +
                ", Nom='" + Nom + '\'' +
                '}';
    }
    @OneToMany()
    private ArrayList<FonctionEmployeKey> Employe;
}
