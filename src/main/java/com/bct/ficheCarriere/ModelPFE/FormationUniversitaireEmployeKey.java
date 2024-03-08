package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FormationUniversitaireEmployeKey")
public class FormationUniversitaireEmployeKey {
     @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private long id;
   
    @ManyToOne()
    @JoinColumn(name = "matricule")
    private Employe employe;

    @ManyToOne()
    @JoinColumn(name="idFormationUniversitaire")
    private  FormationUniversitaire formationUniversiataire;

}
