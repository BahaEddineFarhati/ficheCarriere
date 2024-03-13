package com.bct.ficheCarriere.ModelPFE;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Employe")
public class Employe {
    @jakarta.persistence.Id
    @Id
    private String matricule;
    private String nom;
    private String prenom ;
    private String image ;
    private String email ;
    private Date dateDeNaissance ;
    private String adresse ;
    private String responsabilite ;
    private String recompenceEtReconnaissance ;
    private Boolean disponibilitePourDesMissionALEtranger;
    private Boolean disponibilitePourDesChangementsDePoste;
    private Boolean disponibilitePourDesDeplacements;

    @ManyToMany(mappedBy = "Employees")
    private Set<Fonction> fonctions = new HashSet<>();


//    @OneToMany()
//    private ArrayList<ConferenceEmployeKey> idConference;

    @JsonManagedReference
    @ManyToMany(mappedBy = "Employees")
    private Set<Conference> Conferences = new HashSet<>();

    @ManyToMany(mappedBy = "Employees")
    private Set<Projet> projets = new HashSet<>();

    @ManyToMany(mappedBy = "Employees")
    private Set<FormationUniversitaire> formationUniversitaires = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idDepartement", nullable = false)
    private Departement departement;

    @ManyToMany(mappedBy = "employees")
    private Set<Grade> grades = new HashSet<>();


   

}