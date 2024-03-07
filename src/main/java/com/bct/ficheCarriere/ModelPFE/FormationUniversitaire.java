package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "FormationUniersitaire ")
public class FormationUniversitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Type;
    private String NomDuDiplome;
    private  String Faculte;
    private Date DateDobtention;

    public FormationUniversitaire(String type, String nomDuDiplome, String faculte, Date dateDobtention) {
        Type = type;
        NomDuDiplome = nomDuDiplome;
        Faculte = faculte;
        DateDobtention = dateDobtention;
    }

    public FormationUniversitaire() {

    }


    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getNomDuDiplome() {
        return NomDuDiplome;
    }

    public void setNomDuDiplome(String nomDuDiplome) {
        NomDuDiplome = nomDuDiplome;
    }

    public String getFaculte() {
        return Faculte;
    }

    public void setFaculte(String faculte) {
        Faculte = faculte;
    }

    public Date getDateDobtention() {
        return DateDobtention;
    }

    public void setDateDobtention(Date dateDobtention) {
        DateDobtention = dateDobtention;
    }

    @Override
    public String toString() {
        return "FormationUniversitaire{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                ", NomDuDiplome='" + NomDuDiplome + '\'' +
                ", Faculte='" + Faculte + '\'' +
                ", DateDobtention=" + DateDobtention +
                '}';
    }

   @ManyToOne
   @JoinColumn(name = "Matricule", nullable = false)
    private Employe employe;


}
