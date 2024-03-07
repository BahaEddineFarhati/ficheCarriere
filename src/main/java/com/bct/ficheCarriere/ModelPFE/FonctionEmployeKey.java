package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;



@Entity
@Table(name = "FonctionEmployeKey ")

public class FonctionEmployeKey {
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private long id;
   
    @ManyToOne()
    @JoinColumn(name = "matricule")
    private Employe employe;

    @ManyToOne()
    @JoinColumn(name="idfonction")
    private  Fonction fonction;

    
}
