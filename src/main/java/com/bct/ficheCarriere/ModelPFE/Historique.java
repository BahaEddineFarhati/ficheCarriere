package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Historique ")
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private Date date;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @ManyToOne
    @JoinColumn(name = "Id", nullable = false)
    private Utilisateur utilisateur;

    public Historique(Date date, Utilisateur utilisateur) {
        this.date = date;
        this.utilisateur = utilisateur;
    }

    public Historique() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "id=" + id +
                ", date=" + date +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
