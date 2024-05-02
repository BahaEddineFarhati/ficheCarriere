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
public class CompetenceTechnique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_CT;
    private String nom ;
}
