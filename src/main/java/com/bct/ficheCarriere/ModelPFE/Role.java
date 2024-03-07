package com.bct.ficheCarriere.ModelPFE;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;
    private String nom;

     public Role(String nom) {
         this.nom = nom;
     }

    public Role() {

    }

    public long getId() {
         return id;
     }

     public String getNom() {
         return nom;
     }

     public void setId(long id) {
         this.id = id;
     }

     public void setNom(String nom) {
         this.nom = nom;
     }

     @Override
     public String toString() {
         return "Role{" +
                 "id=" + id +
                 ", nom='" + nom + '\'' +
                 '}';
     }
    @OneToMany()
      private ArrayList<Utilisateur> utilisateur;



 }
