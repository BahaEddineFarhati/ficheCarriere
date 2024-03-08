package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Departement;
import com.bct.ficheCarriere.ModelPFE.Employe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

//    private final Departement d = new Departement("SI","SI");
//    Date currentDate = new Date();
//    private final Employe testEmpl1 = new Employe("1","Farhati","Baha","img1","baha@mail.tn",currentDate,"adresse","test","test",true,true,false,d) ;


    @GetMapping
    public String getEmploye () {
        return "Serveur yakhdem !";
    }


}
