package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {


    //<editor-fold desc="Person class example">
    private final Departement d = new Departement("SI","SI");
    Date currentDate = new Date();

    Set<Fonction> f = new HashSet<>();
    Set<Conference> c = new HashSet<>();
    Set<Projet> p = new HashSet<>();
    Set<FormationUniversitaire> fr = new HashSet<>();
    Set<Grade> g = new HashSet<>();

    public final Employe testEmpl1 = new Employe("1","Farhati","Baha","img1","baha@mail.tn",currentDate,"adresse","test","test",true,true,false,f,c,p,fr,d,g) ;

    //</editor-fold>

    @GetMapping
    public Employe getEmploye () {
        return testEmpl1;
    }


}
