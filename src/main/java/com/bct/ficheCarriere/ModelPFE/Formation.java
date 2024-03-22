package com.bct.ficheCarriere.ModelPFE;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Formation {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
        private String nom;
	    private String sujet;
	    private Date date;

}
