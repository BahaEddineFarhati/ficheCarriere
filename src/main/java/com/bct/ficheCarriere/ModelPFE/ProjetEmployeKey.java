package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;


@Entity
@Table(name = "ProjetEmployeKey")


public class ProjetEmployeKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

    
    @ManyToOne()
    @JoinColumn(name = "matricule")
    private Employe employe;

    @ManyToOne()
    @JoinColumn(name="idprojet")
    private Projet projet;

}