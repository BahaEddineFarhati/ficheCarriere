package com.bct.ficheCarriere.ModelPFE.CompetencesClasses;


import com.bct.ficheCarriere.ModelPFE.Employe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CompetenceInformatique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_CI;
    private String nom ;
}
