package com.bct.ficheCarriere.ModelPFE.dto;


import com.bct.ficheCarriere.ModelPFE.*;
import com.bct.ficheCarriere.ModelPFE.CompetencesClasses.CompetenceInformatique;
import com.bct.ficheCarriere.ModelPFE.CompetencesClasses.CompetenceTechnique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeRhInfo {
    private Long Id ;
    private String responsabilite ;
    private String recompenceEtReconnaissance ;
    private Boolean disponibilitePourDesMissionALEtranger;
    private Boolean disponibilitePourDesChangementsDePoste;
    private Boolean disponibilitePourDesDeplacements;
    private List<Formation> formations = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();
    private List<Conference> conferences = new ArrayList<>();
    private List<CompetenceTechnique> competencesTechniques = new ArrayList<>() ;
    private List<CompetenceInformatique> competencesInformatiques = new ArrayList<>()  ;
    private String niveauLangueFrancais ;
    private String niveauLangueAnglais ;
}
