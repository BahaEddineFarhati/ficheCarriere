package com.bct.ficheCarriere.ModelPFE;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
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

    @ManyToMany(mappedBy = "Employees")
    private Set<Fonction> fonctions = new HashSet<>();


//    @OneToMany()
//    private ArrayList<ConferenceEmployeKey> idConference;


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


    public Employe(String matricule, String nom, String prenom, String image, String email, Date dateDeNaissance, String adresse, String responsabilite, String recompenceEtReconnaissance, Boolean disponibilitePourDesMissionALEtranger, Boolean disponibilitePourDesChangementsDePoste, Boolean disponibilitePourDesDeplacements, Set<Fonction> fonctions, Set<Conference> conferences, Set<Projet> projets, Set<FormationUniversitaire> formationUniversitaires, Departement departement, Set<Grade> grades) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
        this.responsabilite = responsabilite;
        this.recompenceEtReconnaissance = recompenceEtReconnaissance;
        this.disponibilitePourDesMissionALEtranger = disponibilitePourDesMissionALEtranger;
        this.disponibilitePourDesChangementsDePoste = disponibilitePourDesChangementsDePoste;
        this.disponibilitePourDesDeplacements = disponibilitePourDesDeplacements;
        this.fonctions = fonctions;
        Conferences = conferences;
        this.projets = projets;
        this.formationUniversitaires = formationUniversitaires;
        this.departement = departement;
        this.grades = grades;
    }

    public Employe() {
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getResponsabilite() {
        return responsabilite;
    }

    public void setResponsabilite(String responsabilite) {
        this.responsabilite = responsabilite;
    }

    public String getRecompenceEtReconnaissance() {
        return recompenceEtReconnaissance;
    }

    public void setRecompenceEtReconnaissance(String recompenceEtReconnaissance) {
        this.recompenceEtReconnaissance = recompenceEtReconnaissance;
    }

    public Boolean getDisponibilitePourDesMissionALEtranger() {
        return disponibilitePourDesMissionALEtranger;
    }

    public void setDisponibilitePourDesMissionALEtranger(Boolean disponibilitePourDesMissionALEtranger) {
        this.disponibilitePourDesMissionALEtranger = disponibilitePourDesMissionALEtranger;
    }

    public Boolean getDisponibilitePourDesChangementsDePoste() {
        return disponibilitePourDesChangementsDePoste;
    }

    public void setDisponibilitePourDesChangementsDePoste(Boolean disponibilitePourDesChangementsDePoste) {
        this.disponibilitePourDesChangementsDePoste = disponibilitePourDesChangementsDePoste;
    }

    public Boolean getDisponibilitePourDesDeplacements() {
        return disponibilitePourDesDeplacements;
    }

    public void setDisponibilitePourDesDeplacements(Boolean disponibilitePourDesDeplacements) {
        this.disponibilitePourDesDeplacements = disponibilitePourDesDeplacements;
    }

    public Set<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(Set<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    public Set<Conference> getConferences() {
        return Conferences;
    }

    public void setConferences(Set<Conference> conferences) {
        Conferences = conferences;
    }

    public Set<Projet> getProjets() {
        return projets;
    }

    public void setProjets(Set<Projet> projets) {
        this.projets = projets;
    }

    public Set<FormationUniversitaire> getFormationUniversitaires() {
        return formationUniversitaires;
    }

    public void setFormationUniversitaires(Set<FormationUniversitaire> formationUniversitaires) {
        this.formationUniversitaires = formationUniversitaires;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
