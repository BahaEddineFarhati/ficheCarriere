package com.bct.ficheCarriere.ModelPFE;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    @OneToMany()
    private ArrayList<FonctionEmployeKey> idFonction;

    @OneToMany()
    private ArrayList<Publication> idPublication;

    @OneToMany()
    private ArrayList<ConferenceEmployeKey> idConference;

    @OneToMany()
    private ArrayList<ProjetEmployeKey> idProjet;

    @OneToMany()
    private ArrayList<FormationUniversitaireEmployeKey> idFormationUniv;

    @ManyToOne
    @JoinColumn(name = "idDepartement", nullable = false)
    private Departement idDepartement;

    @ManyToOne
    @JoinColumn(name = "idGrade", nullable = false)
    private Grade idGrade;
    
}
