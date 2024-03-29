package com.bct.ficheCarriere.ModelPFE.dto;

import com.bct.ficheCarriere.ModelPFE.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeBaseProfilinformation {
    private String matricule;
    private String nom;
    private String prenom ;
    private String image ;
    private String email ;
    private Integer numeroTelephone ;
    private Date dateDeNaissance ;
    private String adresse ;
    private Fonction fonction;
    private FormationUniversitaire formationUniv;
    private Departement departement;
    private List<Publication> publications = new ArrayList<>();


}
