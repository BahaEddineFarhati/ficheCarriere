package com.bct.ficheCarriere.ModelPFE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Conference")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String nom;
    private String sujet;
    private String pays;
    @JsonIgnore
    @OneToMany(mappedBy = "conference")
    private List<EmployeConference> employeConference = new ArrayList<>() ;
  
   /* @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Conference_employe",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "matricule"))
  @JsonIgnore
    private List<Employe> Employees = new ArrayList<>();
*/
//@OneToMany
//private ArrayList<ConferenceEmployeKey> idEmploye;


}
