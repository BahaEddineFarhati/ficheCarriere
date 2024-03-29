package com.bct.ficheCarriere.ModelPFE.dto;

import com.bct.ficheCarriere.ModelPFE.Utilisateur;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class historiqueDTO {
    private  Long id;
    private Date date;
    private String adresseIp ;

    private String nom ;

    private String prenom ;

    private String matricule ;

    private String departement ;

    private String role ;
}
