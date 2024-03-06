package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Utilisateur ")
public class Utilisateur extends Employe{



    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
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
                ", role=" + role +
                '}';
    }



}
