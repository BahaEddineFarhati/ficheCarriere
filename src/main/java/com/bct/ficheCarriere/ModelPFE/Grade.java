package com.bct.ficheCarriere.ModelPFE;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String Direction;
    private String Service;

@JsonIgnore
    @OneToMany(mappedBy = "grade")
    private List<EmployeGrade> employeGrade = new ArrayList<>() ;

    
// @OneToMany(mappedBy = "idGrade")
//private List<Employe> employes = new ArrayList<>();

 /*   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Grade_Employe",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "matricule"))
    private Set<Employe> employees = new HashSet<>();
*/

}
