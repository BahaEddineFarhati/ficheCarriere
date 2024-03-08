package com.bct.ficheCarriere.ModelPFE;
import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "FormationUniersitaire ")
public class FormationUniversitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String nomDuDiplome;
    private  String faculte;
    private Date dateDobtention;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "FormationUniversitaire_Employe",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "matricule"))
    private Set<Employe> Employees = new HashSet<>();


}
