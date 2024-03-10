package com.bct.ficheCarriere.ModelPFE;
import java.util.ArrayList;

import lombok.*;
import jakarta.persistence.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
@Table(name = "Departement ")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String abreviation;
    private String nom;


    public Departement( String abreviation, String nom) {
        this.abreviation = abreviation;
        this.nom = nom;
    }

    public Departement() {
    }



}
