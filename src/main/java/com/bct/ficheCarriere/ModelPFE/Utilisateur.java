package com.bct.ficheCarriere.ModelPFE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Utilisateur")
public class Utilisateur extends Employe {

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false) // Change "role_id" to the actual column name in your database
    private Role role;
    @OneToMany()
    private ArrayList<Historique> idHistorique;
}