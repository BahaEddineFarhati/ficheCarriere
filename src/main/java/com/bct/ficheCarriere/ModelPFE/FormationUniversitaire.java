package com.bct.ficheCarriere.ModelPFE;
import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "FormationUniersitaire ")
public class FormationUniversitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String nomDuDiplome;
    private  String faculte;
    private Date dateDobtention;

    @OneToMany()
    private ArrayList<FormationUniversitaireEmployeKey> idEmploye;


}
