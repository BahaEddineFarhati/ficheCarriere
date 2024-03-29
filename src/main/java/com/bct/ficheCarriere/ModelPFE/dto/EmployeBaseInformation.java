package com.bct.ficheCarriere.ModelPFE.dto;

import com.bct.ficheCarriere.ModelPFE.Departement;
import com.bct.ficheCarriere.ModelPFE.Fonction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeBaseInformation {
    private String matricule ;
    private String nom ;
    private String prenom ;
    private Departement departement;
    private Fonction fonction;

}
