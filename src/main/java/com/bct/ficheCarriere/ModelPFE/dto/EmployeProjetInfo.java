package com.bct.ficheCarriere.ModelPFE.dto;

import com.bct.ficheCarriere.ModelPFE.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeProjetInfo {
    private List<Projet> projets = new ArrayList<>();
    private String responsabilite ;
    private List<Formation> formations = new ArrayList<>();
    private String competences ;



}
