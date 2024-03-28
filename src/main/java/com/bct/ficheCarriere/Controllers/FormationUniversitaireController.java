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

import com.bct.ficheCarriere.ModelPFE.FormationUniversitaire;

import com.bct.ficheCarriere.service.FormationUniversitaireService;

@RestController
@RequestMapping("/FormationUniv")
public class FormationUniversitaireController {
	@Autowired
	    private final FormationUniversitaireService formationUniversitaireService;

	    
	    public FormationUniversitaireController(FormationUniversitaireService formationUniversitaireService) {
	        this.formationUniversitaireService = formationUniversitaireService;
	    }

	    @PostMapping("/addFormationUniversitaire")
	    public ResponseEntity<FormationUniversitaire> addFormationUniversitaire(@RequestBody FormationUniversitaire formationUniversitaire) {
	        FormationUniversitaire savedFormationUniversitaire = formationUniversitaireService.createFormationUniversitaire(formationUniversitaire);
	        return new ResponseEntity<>(savedFormationUniversitaire, HttpStatus.CREATED);
	    }

	    @GetMapping("/getAllFormationsUniversitaires")
	    public ResponseEntity<List<FormationUniversitaire>> getAllFormationsUniversitaires() {
	        List<FormationUniversitaire> formationsUniversitaires = formationUniversitaireService.getAllFormationsUniversitaires();
	        return new ResponseEntity<>(formationsUniversitaires, HttpStatus.OK);
	    }

	    @GetMapping("/getFormationUniversitaire/{id}")
	    public ResponseEntity<FormationUniversitaire> getFormationUniversitaireById(@PathVariable Long id) {
	        Optional<FormationUniversitaire> formationUniversitaire = formationUniversitaireService.getFormationUniversitaireById(id);
	        return formationUniversitaire.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/updateFormationUniversitaire/{id}")
	    public ResponseEntity<FormationUniversitaire> updateFormationUniversitaire(@PathVariable Long id, @RequestBody FormationUniversitaire updatedFormationUniversitaire) {
	        FormationUniversitaire updated = formationUniversitaireService.updateFormationUniversitaire(id, updatedFormationUniversitaire);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteFormationUniversitaire/{id}")
	    public ResponseEntity<Void> deleteFormationUniversitaire(@PathVariable Long id) {
	        formationUniversitaireService.deleteFormationUniversitaireById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}

	  
	    