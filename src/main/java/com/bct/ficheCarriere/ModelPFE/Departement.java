package com.bct.ficheCarriere.ModelPFE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String abreviation;
    private String nom;
    
 


}
