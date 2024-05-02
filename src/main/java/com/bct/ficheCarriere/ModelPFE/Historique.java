package com.bct.ficheCarriere.ModelPFE;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date date;
    private String adresseIp ;


 @ManyToOne
    @JoinColumn(name = "idUtilisateur", nullable = false)
    private Utilisateur utilisateur;
}
