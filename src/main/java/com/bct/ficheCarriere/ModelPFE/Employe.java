package com.bct.ficheCarriere.ModelPFE;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
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
    
    

    @ManyToOne
    @JoinColumn(name = "idFonction", nullable = false)
    private Fonction fonction;

    @ManyToOne
    @JoinColumn(name = "idFormationUniversitaire", nullable = false)
    private FormationUniversitaire formationUniv;
   
    @ManyToOne
    @JoinColumn(name = "idDepartement", nullable = false)
    private Departement departement;
    
    @ManyToOne
    @JoinColumn(name = "idFormation", nullable = false)
    private Formation formation;
    

    @OneToMany(mappedBy = "employe")
    private List<EmployeGrade> EmployeGrade = new ArrayList<>();

    @OneToMany(mappedBy = "employe")
    private List<EmployeProjet> employeProjet = new ArrayList<>();
    
    @OneToMany(mappedBy = "employe")
    private List<EmployeConference> employeConference = new ArrayList<>();
    
 

//  @OneToMany()
//  private ArrayList<ConferenceEmployeKey> idConference;
}