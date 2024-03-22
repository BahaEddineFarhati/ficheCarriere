package com.bct.ficheCarriere.ModelPFE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Date date;
    private String roleProjet;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Projet_Employe",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "matricule"))
    private Set<Employe> Employees = new HashSet<>();

}
