package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur extends Employe {

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false) // Change "role_id" to the actual column name in your database
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "role=" + role +
                '}';
    }
}