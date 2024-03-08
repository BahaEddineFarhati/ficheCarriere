package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Fonction")
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private  Long id;
 private Date date;
 private String nom;
 @OneToMany()
    private ArrayList<FonctionEmployeKey> idEmploye;
}
