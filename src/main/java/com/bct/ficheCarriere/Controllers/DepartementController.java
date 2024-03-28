package com.bct.ficheCarriere.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.bct.ficheCarriere.service.DepartementService;

@RestController
@RequestMapping("/Departement")
public class DepartementController {
	@Autowired
	    private  DepartementService departementService;

	
	    public DepartementController(DepartementService departementService) {
	        this.departementService = departementService;
	    }

	    @PostMapping("/addDepartement")
	    public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement) {
	        Departement savedDepartement = departementService.createDepartement(departement);
	        return new ResponseEntity<>(savedDepartement, HttpStatus.CREATED);
	    }

	    @GetMapping("/getAllDepartements")
	    public ResponseEntity<List<Departement>> getAllDepartements() {
	        List<Departement> departements = departementService.getAllDepartements();
	        return new ResponseEntity<>(departements, HttpStatus.OK);
	    }

	    @GetMapping("/getDepartement/{id}")
	    public ResponseEntity<Departement> getDepartementById(@PathVariable Long id) {
	        Optional<Departement> departement = departementService.getDepartementById(id);
	        return departement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/updateDepartement/{id}")
	    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id, @RequestBody Departement updatedDepartement) {
	        Departement updated = departementService.updateDepartement(id, updatedDepartement);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteDepartement/{id}")
	    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
	        departementService.deleteDepartementById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}


