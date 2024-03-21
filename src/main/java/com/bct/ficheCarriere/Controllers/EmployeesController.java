package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Conference;
import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.Repositories.ConferenceRepository;
import com.bct.ficheCarriere.Repositories.EmployeRepository;
import com.bct.ficheCarriere.service.EmployeService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employes")
public class EmployeesController {

    @Autowired
    private EmployeService employeService;
    @Autowired
    private  ConferenceRepository conferenceRepository;
    @Autowired
    private EmployeRepository employeRepository;

    @PostMapping("/addEmploye/{id}")
    public ResponseEntity<Employe> saveEmploye(@RequestBody Employe employe) {
        Employe savedEmploye = employeService.saveEmploye(employe);
        return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    @GetMapping("/getEmploye/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Optional<Employe> employe = employeService.getEmployeById(id);
        return employe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteEmploye/{id}")
    public ResponseEntity<Void> deleteEmployeById(@PathVariable Long id) {
        employeService.deleteEmployeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/updateEmploye/{employeId}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long employeId, @RequestBody Employe employeUpdates) {
        Employe updatedEmploye = employeService.updateEmploye(employeId, employeUpdates);
        return new ResponseEntity<>(updatedEmploye, HttpStatus.OK);
    }
  //update the relation employe-conference
   @Transactional
    @PutMapping("/{empId}/Conference/{confId}")
   public Employe employe_conf(@PathVariable Long empId, @PathVariable Long confId) {
       if (empId == null) {
           throw new IllegalArgumentException("L'ID de l'employé ne peut pas être null");
       }
       if (confId == null) {
           throw new IllegalArgumentException("L'ID de la conférence ne peut pas être null");
       }

       // Retrieve employe and conference entities from repositories
       Employe employe = employeRepository.findById(empId)
               .orElseThrow(() -> new IllegalArgumentException("Employé avec l'ID " + empId + " introuvable"));

       Conference conference = conferenceRepository.findById(confId)
               .orElseThrow(() -> new IllegalArgumentException("Conférence avec l'ID " + confId + " introuvable"));

       // Update both sides of the relationship
       List<Conference> conferenceSet = employe.getConferences();
       conferenceSet.add(conference);
       employe.setConferences(conferenceSet);
       employe = employeRepository.save(employe);

       List<Employe> employees = conference.getEmployees();
       employees.add(employe);
       conference.setEmployees(employees);
       conferenceRepository.save(conference);

       return employe;
   }


    }
    
    
   
    
    

