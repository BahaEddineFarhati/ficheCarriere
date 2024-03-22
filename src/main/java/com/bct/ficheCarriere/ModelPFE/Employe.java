package com.bct.ficheCarriere.ModelPFE;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    @JsonBackReference
    private List<Conference> Conferences = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idFonctiont", nullable = false)
    private Fonction fonction;


    @ManyToMany(mappedBy = "Employees")
    private Set<Projet> projets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idFormationUniversitaire", nullable = false)
    private FormationUniversitaire formationUniv;
   
    @ManyToOne
    @JoinColumn(name = "idDepartement", nullable = false)
    private Departement departement;

    @ManyToMany(mappedBy = "employees" , cascade = {CascadeType.ALL})
    private Set<Grade> grades = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idFormation", nullable = false)
    private Formation formation;
   

//  @OneToMany()
//  private ArrayList<ConferenceEmployeKey> idConference;
}