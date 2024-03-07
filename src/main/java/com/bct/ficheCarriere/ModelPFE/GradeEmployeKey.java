package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;


@Entity
@Table(name = "radeEmployeKey")

public class GradeEmployeKey  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

 
    @ManyToOne()
    @JoinColumn(name = "matricule")
    private Employe employe;

    @ManyToOne()
    @JoinColumn(name="IdGrade")
    private Grade grade ;

}
