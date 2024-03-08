package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departement ")
public class Arij {

    @Id
private Long id;
private String nom;
}
