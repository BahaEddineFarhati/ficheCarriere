package com.bct.ficheCarriere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.ficheCarriere.ModelPFE.Formation;
import com.bct.ficheCarriere.Repositories.FormationRepository;

@Service
public class FormationService {
	
	    private FormationRepository formationRepository;

	    @Autowired
	    public FormationService(FormationRepository formationRepository) {
	        this.formationRepository = formationRepository;
	    }

	    public Formation createFormation(Formation formation) {
	        return formationRepository.save(formation);
	    }

	    public List<Formation> getAllFormations() {
	        return formationRepository.findAll();
	    }

	    
	    public Optional<Formation> getFormationById(Long id) {
	        return formationRepository.findById(id);
	    }

	    public Formation updateFormation(Long id, Formation updatedFormation) {
	        Formation formationToUpdate = formationRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Formation with ID " + id + " not found"));
	        formationToUpdate.setNom(updatedFormation.getNom());
	        formationToUpdate.setSujet(updatedFormation.getSujet());
	        formationToUpdate.setDate(updatedFormation.getDate());
	        return formationRepository.save(formationToUpdate);
	    }

	  
	    public void deleteFormationById(Long id) {
	        formationRepository.deleteById(id);
	    }
	}



