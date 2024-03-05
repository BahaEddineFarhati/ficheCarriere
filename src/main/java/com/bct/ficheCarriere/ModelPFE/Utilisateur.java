package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Utilisateur ")
public class Utilisateur {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id ;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Role role;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "Id=" + Id +
                ", role=" + role +
                '}';
    }



}
