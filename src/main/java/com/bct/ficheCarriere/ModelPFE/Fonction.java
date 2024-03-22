package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

 private  Long id;
 private Date date;
 private String nom;



   /* @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Fonction_employe",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "matricule"))
    private Set<Employe> Employees = new HashSet<>();*/
}
