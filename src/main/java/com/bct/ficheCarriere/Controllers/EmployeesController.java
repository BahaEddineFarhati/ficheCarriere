package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.service.EmployeService;
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

    @PostMapping("/{id}")
    public ResponseEntity<Employe> saveEmploye(@RequestBody Employe employe) {
        Employe savedEmploye = employeService.saveEmploye(employe);
        return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Optional<Employe> employe = employeService.getEmployeById(id);
        return employe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeById(@PathVariable Long id) {
        employeService.deleteEmployeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        Optional<Employe> existingEmploye = employeService.getEmployeById(id);
        if (existingEmploye.isPresent()) {
            employe.setId(id);
            Employe updatedEmploye = employeService.updateEmploye(employe);
            return new ResponseEntity<>(updatedEmploye, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    @GetMapping("/test/{employeeId}")
    public ResponseEntity<Employe> getEmployeeWithConferences(@PathVariable Long employeeId) {
        Optional<Employe> employeeOptional = employeService.getEmployeeWithConferences(employeeId);
        if (employeeOptional.isPresent()) {
            return ResponseEntity.ok(employeeOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
