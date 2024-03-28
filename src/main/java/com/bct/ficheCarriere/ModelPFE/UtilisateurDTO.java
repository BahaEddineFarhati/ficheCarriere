package com.bct.ficheCarriere.ModelPFE;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UtilisateurDTO {

        private String username ;
        private String password ;
        private String role ;
        private String departement ;
        private Long Fonction ;
        private Long Formation ;
        private Long FormationUniversitaire ;
}
