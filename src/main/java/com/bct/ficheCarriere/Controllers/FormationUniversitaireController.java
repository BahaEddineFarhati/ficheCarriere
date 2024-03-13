package com.bct.ficheCarriere.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bct.ficheCarriere.ModelPFE.FormationUniversitaire;
import com.bct.ficheCarriere.Repositories.FormationUniversitaireRepository;

@RestController
@RequestMapping("/formationUniv")
public class FormationUniversitaireController {
	

	    @Autowired
	    private FormationUniversitaireRepository formationRepository;

	  
	    @PostMapping("/add")
	    public FormationUniversitaire addFormation(@RequestBody FormationUniversitaire formation) {
	        return formationRepository.save(formation);
	    }


	    @GetMapping("/all")
	    public List<FormationUniversitaire> getAllFormations() {
	        return formationRepository.findAll();
	    }

	  
	    @GetMapping("/{id}")
	    public Optional<FormationUniversitaire> getFormationById(@PathVariable Long id) {
	        return formationRepository.findById(id);
	    }


	    @PutMapping("/{id}")
	    public FormationUniversitaire updateFormation(@PathVariable Long id, @RequestBody FormationUniversitaire updatedFormation) {
	        updatedFormation.setId(id);
	        return formationRepository.save(updatedFormation);
	    }

	
	    @DeleteMapping("/{id}")
	    public void deleteFormation(@PathVariable Long id) {
	        formationRepository.deleteById(id);
	    }
	}



