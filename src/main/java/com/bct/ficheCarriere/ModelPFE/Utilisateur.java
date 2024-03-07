package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Utilisateur ")
public class Utilisateur extends Employe{



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                ", role=" + role +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "Id", nullable = false)
    private Role role;


}
