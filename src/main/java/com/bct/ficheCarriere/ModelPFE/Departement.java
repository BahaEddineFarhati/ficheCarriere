package com.bct.ficheCarriere.ModelPFE;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "Departement ")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
    private String Abreviation;
    private String Nom;

    public Departement() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getAbreviation() {
        return Abreviation;
    }

    public void setAbreviation(String abreviation) {
        Abreviation = abreviation;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Departement(String abreviation, String nom) {
        Abreviation = abreviation;
        Nom = nom;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "Id=" + Id +
                ", Abreviation='" + Abreviation + '\'' +
                ", Nom='" + Nom + '\'' +
                '}';
    }
 @OneToMany()
    private ArrayList<Employe> employe;

}
