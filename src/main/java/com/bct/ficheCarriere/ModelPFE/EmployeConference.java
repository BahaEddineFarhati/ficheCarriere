package com.bct.ficheCarriere.ModelPFE;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EmployeConference {
	
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;

		    @ManyToOne
		    private Employe employe ;

		    @ManyToOne
		    private Conference conference ;


		}




