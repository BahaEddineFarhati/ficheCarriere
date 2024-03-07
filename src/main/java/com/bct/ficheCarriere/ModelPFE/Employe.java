package com.bct.ficheCarriere.ModelPFE;


import jakarta.persistence.*;

import org.springframework.data.annotation.Id;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Employe")
public class Employe {
    @jakarta.persistence.Id
    @Id
    private String Matricule;
    private String Nom;
    private String Prenom ;
    private String Image ;
    private String Email ;
    private Date DateDeNaissance ;
    private String Adresse ;
    private String Responsabilite ;
    private String RecompenceEtReconnaissance ;
    private Boolean DisponibilitePourDesMissionALEtranger;
    private Boolean DisponibilitePourDesChangementsDePoste;
    private Boolean DisponibilitePourDesDeplacements;


    public Employe(String matricule, String nom, String prenom, String image, String email, Date dateDeNaissance, String adresse, String responsabilite, String recompenceEtReconnaissance, Boolean disponibilitePourDesMissionALEtranger, Boolean disponibilitePourDesChangementsDePoste, Boolean disponibilitePourDesDeplacements , Departement departement) {
        Matricule = matricule;
        Nom = nom;
        Prenom = prenom;
        Image = image;
        Email = email;
        DateDeNaissance = dateDeNaissance;
        Adresse = adresse;
        Responsabilite = responsabilite;
        RecompenceEtReconnaissance = recompenceEtReconnaissance;
        DisponibilitePourDesMissionALEtranger = disponibilitePourDesMissionALEtranger;
        DisponibilitePourDesChangementsDePoste = disponibilitePourDesChangementsDePoste;
        DisponibilitePourDesDeplacements = disponibilitePourDesDeplacements;
        this.departement = departement ;
    }

    public Employe () {}



    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDateDeNaissance() {
        return DateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        DateDeNaissance = dateDeNaissance;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getResponsabilite() {
        return Responsabilite;
    }

    public void setResponsabilite(String responsabilite) {
        Responsabilite = responsabilite;
    }

    public String getRecompenceEtReconnaissance() {
        return RecompenceEtReconnaissance;
    }

    public void setRecompenceEtReconnaissance(String recompenceEtReconnaissance) {
        RecompenceEtReconnaissance = recompenceEtReconnaissance;
    }

    public Boolean getDisponibilitePourDesMissionALEtranger() {
        return DisponibilitePourDesMissionALEtranger;
    }

    public void setDisponibilitePourDesMissionALEtranger(Boolean disponibilitePourDesMissionALEtranger) {
        DisponibilitePourDesMissionALEtranger = disponibilitePourDesMissionALEtranger;
    }

    public Boolean getDisponibilitePourDesChangementsDePoste() {
        return DisponibilitePourDesChangementsDePoste;
    }

    public void setDisponibilitePourDesChangementsDePoste(Boolean disponibilitePourDesChangementsDePoste) {
        DisponibilitePourDesChangementsDePoste = disponibilitePourDesChangementsDePoste;
    }

    public Boolean getDisponibilitePourDesDeplacements() {
        return DisponibilitePourDesDeplacements;
    }

    public void setDisponibilitePourDesDeplacements(Boolean disponibilitePourDesDeplacements) {
        DisponibilitePourDesDeplacements = disponibilitePourDesDeplacements;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "Matricule='" + Matricule + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Image='" + Image + '\'' +
                ", Email='" + Email + '\'' +
                ", DateDeNaissance=" + DateDeNaissance +
                ", Adresse='" + Adresse + '\'' +
                ", Responsabilite='" + Responsabilite + '\'' +
                ", RecompenceEtReconnaissance='" + RecompenceEtReconnaissance + '\'' +
                ", DisponibilitePourDesMissionALEtranger=" + DisponibilitePourDesMissionALEtranger +
                ", DisponibilitePourDesChangementsDePoste=" + DisponibilitePourDesChangementsDePoste +
                ", DisponibilitePourDesDeplacements=" + DisponibilitePourDesDeplacements +
                ", departement=" + departement +
                '}';
    }


    @OneToMany()
    private ArrayList<ConferenceEmployeKey> conference ;

    @OneToMany()
    private ArrayList<GradeEmployeKey> grade ;

    @OneToMany()
    private ArrayList<ProjetEmployeKey> fonction;


    @OneToMany()
    private ArrayList<ProjetEmployeKey> projet;

   


    @ManyToOne
    @JoinColumn(name = "Id", nullable = false)
    private Departement departement;

}
