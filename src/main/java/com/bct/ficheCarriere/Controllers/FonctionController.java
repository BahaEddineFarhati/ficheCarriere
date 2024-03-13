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

import com.bct.ficheCarriere.ModelPFE.Fonction;
import com.bct.ficheCarriere.Repositories.FonctionRepository;

@RestController
@RequestMapping("/fonctions")
public class FonctionController {
	

	    @Autowired
	    private FonctionRepository fonctionRepository;

	   
	    @GetMapping
	    public List<Fonction> getAllFonctions() {
	        return fonctionRepository.findAll();
	    }

	  
	    @GetMapping("/{id}")
	    public ResponseEntity<Fonction> getFonctionById(@PathVariable Long id) {
	        return fonctionRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	 
	    @PostMapping
	    public ResponseEntity<Fonction> createFonction(@RequestBody Fonction fonction) {
	        Fonction savedFonction = fonctionRepository.save(fonction);
	        return ResponseEntity.ok(savedFonction);
	    }

	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Fonction> updateFonction(@PathVariable Long id, @RequestBody Fonction fonction) {
	        if (fonctionRepository.existsById(id)) {
	            fonction.setId(id);
	            Fonction updatedFonction = fonctionRepository.save(fonction);
	            return ResponseEntity.ok(updatedFonction);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteFonction(@PathVariable Long id) {
	        if (fonctionRepository.existsById(id)) {
	            fonctionRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}



