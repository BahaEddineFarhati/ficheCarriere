package com.bct.ficheCarriere.ModelPFE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
@Table(name = "departement ")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String abreviation;
    private String nom;
    
 


    public Departement( String abreviation, String nom) {
        this.abreviation = abreviation;
        this.nom = nom;
    }

    public Departement() {
    }



}
