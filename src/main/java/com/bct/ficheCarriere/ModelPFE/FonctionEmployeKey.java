package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
@Entity
public class FonctionEmployeKey implements Serializable {
    @Id
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "matricule")
    private Employe employe;

    @ManyToOne()
    @JoinColumn(name="idfonction")
    private  Fonction fonction;
}
