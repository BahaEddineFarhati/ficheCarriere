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

import com.bct.ficheCarriere.ModelPFE.Formation;
import com.bct.ficheCarriere.service.FormationService;

@RestController
@RequestMapping("/Formation")
public class FormationController {
	 @Autowired
	    private FormationService formationService;

	   
	    public FormationController(FormationService formationService) {
	        this.formationService = formationService;
	    }

	    @PostMapping("/addFormation")
	    public ResponseEntity<Formation> addFormation(@RequestBody Formation formation) {
	        Formation savedFormation = formationService.createFormation(formation);
	        return new ResponseEntity<>(savedFormation, HttpStatus.CREATED);
	    }

	    @GetMapping("/getAll")
	    public ResponseEntity<List<Formation>> getAllFormations() {
	        List<Formation> formations = formationService.getAllFormations();
	        return new ResponseEntity<>(formations, HttpStatus.OK);
	    }

	    @GetMapping("/getFormation/{id}")
	    public ResponseEntity<Formation> getFormationById(@PathVariable Long id) {
	        Optional<Formation> formation = formationService.getFormationById(id);
	        return formation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/updateFormation/{id}")
	    public ResponseEntity<Formation> updateFormation(@PathVariable Long id, @RequestBody Formation updatedFormation) {
	        Formation updated = formationService.updateFormation(id, updatedFormation);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteFormation/{id}")
	    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
	        formationService.deleteFormationById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}



