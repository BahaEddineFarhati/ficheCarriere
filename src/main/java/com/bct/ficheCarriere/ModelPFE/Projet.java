package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Projet")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Type;
    private Date Date;
    private String RoleProjet;

    

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getRoleProjet() {
        return RoleProjet;
    }
    public void setRoleProjet(String roleProjet) {
        RoleProjet = roleProjet;
    }

    public Projet(String type, java.util.Date date, String roleProjet) {
        Type = type;
        Date = date;
        RoleProjet = roleProjet;
    }
    @Override
    public String toString() {
        return "Projet{" +
                "Id=" + Id +
                ", Type='" + Type + '\'' +
                ", Date=" + Date +
                ", RoleProjet='" + RoleProjet + '\'' +
                '}';
    }

    @OneToMany()
    private ArrayList<ProjetEmployeKey> employe;

}
