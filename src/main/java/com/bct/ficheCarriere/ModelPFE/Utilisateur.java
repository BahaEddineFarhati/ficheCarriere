package com.bct.ficheCarriere.ModelPFE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Utilisateur extends Employe {


    String username ;

    String password ;


    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;




}