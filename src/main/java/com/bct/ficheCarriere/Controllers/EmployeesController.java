package com.bct.ficheCarriere.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.Repositories.EmployeRepository;



@RestController
@RequestMapping("/Employe")
public class EmployeesController {

//    private final Departement d = new Departement("SI","SI");
//    Date currentDate = new Date();
//    private final Employe testEmpl1 = new Employe("1","Farhati","Baha","img1","baha@mail.tn",currentDate,"adresse","test","test",true,true,false,d) ;
	  @Autowired
      private EmployeRepository employeRepository;
   
  /*  @GetMapping
    public String getEmploye () {
        return "Serveur yakhdem !";}
  */  
    

       
        @GetMapping
        public List<Employe> getAllEmployees() {
            return employeRepository.findAll();
        }

        @GetMapping("/{matricule}")
        public ResponseEntity<Employe> getEmployeeByMatricule(@PathVariable String matricule) {
            return employeRepository.findById(matricule)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Employe> createEmployee(@RequestBody Employe employe) {
            Employe savedEmployee = employeRepository.save(employe);
            return ResponseEntity.ok(savedEmployee);
        }

      
        @PutMapping("/{matricule}")
        public ResponseEntity<Employe> updateEmployee(@PathVariable String matricule, @RequestBody Employe employe) {
            if (employeRepository.existsById(matricule)) {
                employe.setMatricule(matricule);
                Employe updatedEmployee = employeRepository.save(employe);
                return ResponseEntity.ok(updatedEmployee);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{matricule}")
        public ResponseEntity<Void> deleteEmployee(@PathVariable String matricule) {
            if (employeRepository.existsById(matricule)) {
                employeRepository.deleteById(matricule);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }



