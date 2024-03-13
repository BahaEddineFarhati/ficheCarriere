package com.bct.ficheCarriere.Controllers;

import java.util.List;

import java.util.Optional;
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

import com.bct.ficheCarriere.ModelPFE.Departement;
import com.bct.ficheCarriere.Repositories.DepartementRepository;

@RestController
@RequestMapping("/departements")
public class DepartementController {


    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping()
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable long id) {
        Optional<Departement> departement = departementRepository.findById(id);
        return departement.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

   @PostMapping
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementRepository.save(departement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable long id, @RequestBody Departement updatedDepartement) {
        Optional<Departement> existingDepartement = departementRepository.findById(id);
        if (existingDepartement.isPresent()) {
            updatedDepartement.setId(id);
            return ResponseEntity.ok(departementRepository.save(updatedDepartement));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable long id) {
        if (departementRepository.existsById(id)) {
            departementRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }}

