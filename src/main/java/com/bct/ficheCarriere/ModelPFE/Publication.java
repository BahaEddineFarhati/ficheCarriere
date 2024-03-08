package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private String nom;
    private String lien;

    @ManyToOne
    @JoinColumn(name = "Matricule", nullable = false)
    private Employe employe;



}
