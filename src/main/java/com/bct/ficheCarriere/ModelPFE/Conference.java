package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import java.util.ArrayList; 
import java.util.Date;

@Entity
@Table(name = "Conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private Date Date;
    private String Nom;
    private String Sujet;
    private  String Pays;


   

    public Conference(java.util.Date date, String nom, String sujet, String pays ) {
        Date = date;
        Nom = nom;
        Sujet = sujet;
        Pays = pays;
     
    }

    public Conference() {

    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public String getSujet() {
        return Sujet;
    }

    public void setSujet(String sujet) {
        Sujet = sujet;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "Id=" + Id +
                ", Date=" + Date +
                ", Nom='" + Nom + '\'' +
                ", Sujet='" + Sujet + '\'' +
                ", Pays='" + Pays + '\'' +
                '}';
    }
    @OneToMany()
    private ArrayList<ConferenceEmployeKey> employe;
   
}