package com.bct.ficheCarriere.ModelPFE;
import com.bct.ficheCarriere.ModelPFE.CompetencesClasses.CompetenceInformatique;
import com.bct.ficheCarriere.ModelPFE.CompetencesClasses.CompetenceTechnique;
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
    private Integer numeroTelephone ;
    private Date dateDeNaissance ;
    private String adresse ;
    private String responsabilite ;
    private String recompenceEtReconnaissance ;
    private Boolean disponibilitePourDesMissionALEtranger;
    private Boolean disponibilitePourDesChangementsDePoste;
    private Boolean disponibilitePourDesDeplacements;
    private String niveauLangueFrancais ;
    private String niveauLangueAnglais ;
    
    

    @ManyToOne
    @JoinColumn(name = "idFonction")
    private Fonction fonction;

    @ManyToOne
    @JoinColumn(name = "idFormationUniversitaire", nullable = false)
    private FormationUniversitaire formationUniv;
   
    @ManyToOne
    @JoinColumn(name = "idDepartement", nullable = false)
    private Departement departement;
    
    @OneToMany
    @JoinColumn(name = "idEmploye")
    private List<Formation> formations = new ArrayList<>();
    

    @OneToMany(mappedBy = "employe")
    private List<EmployeGrade> EmployeGrade = new ArrayList<>();

    @OneToMany(mappedBy = "employe")
    private List<EmployeProjet> employeProjet = new ArrayList<>();
    
    @OneToMany(mappedBy = "employe")
    private List<EmployeConference> employeConference = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "idEmploye")
    private List<CompetenceInformatique> CompetenceInformatique = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "idEmploye")
    private List<CompetenceTechnique> CompetenceTechnique = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_employe", nullable = false)
    private List<Publication> publications = new ArrayList<>();


    
 

//  @OneToMany()
//  private ArrayList<ConferenceEmployeKey> idConference;
}