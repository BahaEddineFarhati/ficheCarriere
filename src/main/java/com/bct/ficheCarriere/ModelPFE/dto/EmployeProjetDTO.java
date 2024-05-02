package com.bct.ficheCarriere.ModelPFE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeProjetDTO {
    private Long id ;
    private String description;
    private Date date;
    private String Nom;
    private String RoleProjet;
}
