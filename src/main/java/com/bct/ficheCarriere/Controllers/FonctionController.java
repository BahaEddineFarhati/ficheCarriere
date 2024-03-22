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

import com.bct.ficheCarriere.ModelPFE.Fonction;
import com.bct.ficheCarriere.Repositories.FonctionRepository;
import com.bct.ficheCarriere.service.FonctionService;

@RestController
@RequestMapping("/Fonction")
public class FonctionController {
	
    private final FonctionService fonctionService;
    
	    @Autowired
	    public FonctionController(FonctionService fonctionService) {
	          this.fonctionService = fonctionService;
	       }

	        @PostMapping("/addFonction")
	        public ResponseEntity<Fonction> addFonction(@RequestBody Fonction fonction) {
	            Fonction savedFonction = fonctionService.createFonction(fonction);
	            return new ResponseEntity<>(savedFonction, HttpStatus.CREATED);
	        }

	        @GetMapping("/getAllFonctions")
	        public ResponseEntity<List<Fonction>> getAllFonctions() {
	            List<Fonction> fonctions = fonctionService.getAllFonctions();
	            return new ResponseEntity<>(fonctions, HttpStatus.OK);
	        }

	        @GetMapping("/getFonction/{id}")
	        public ResponseEntity<Fonction> getFonctionById(@PathVariable Long id) {
	            Optional<Fonction> fonction = fonctionService.getFonctionById(id);
	            return fonction.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	        }

	        @PutMapping("/updateFonction/{id}")
	        public ResponseEntity<Fonction> updateFonction(@PathVariable Long id, @RequestBody Fonction updatedFonction) {
	            Fonction updated = fonctionService.updateFonction(id, updatedFonction);
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        }

	        @DeleteMapping("/deleteFonction/{id}")
	        public ResponseEntity<Void> deleteFonction(@PathVariable Long id) {
	            fonctionService.deleteFonctionById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	    }


	   