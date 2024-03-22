package com.bct.ficheCarriere.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.ficheCarriere.ModelPFE.FormationUniversitaire;
import com.bct.ficheCarriere.Repositories.FormationUniversitaireRepository;

@Service
public class FormationUniversitaireService {
    @Autowired
   
        private FormationUniversitaireRepository formationUniversitaireRepository;

        @Autowired
        public FormationUniversitaireService(FormationUniversitaireRepository formationUniversitaireRepository) {
            this.formationUniversitaireRepository = formationUniversitaireRepository;
        }

    
        public FormationUniversitaire createFormationUniversitaire(FormationUniversitaire formationUniversitaire) {
            return formationUniversitaireRepository.save(formationUniversitaire);
        }

      
        public List<FormationUniversitaire> getAllFormationsUniversitaires() {
            return formationUniversitaireRepository.findAll();
        }

     
        public Optional<FormationUniversitaire> getFormationUniversitaireById(Long id) {
            return formationUniversitaireRepository.findById(id);
        }

      
        public FormationUniversitaire updateFormationUniversitaire(Long id, FormationUniversitaire updatedFormationUniversitaire) {
            FormationUniversitaire formationToUpdate = formationUniversitaireRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Formation universitaire avec l'ID " + id + " non trouvée"));
            formationToUpdate.setType(updatedFormationUniversitaire.getType());
            formationToUpdate.setNomDuDiplome(updatedFormationUniversitaire.getNomDuDiplome());
            formationToUpdate.setFaculte(updatedFormationUniversitaire.getFaculte());
            formationToUpdate.setDateDobtention(updatedFormationUniversitaire.getDateDobtention());
            return formationUniversitaireRepository.save(formationToUpdate);
        }

        
        public void deleteFormationUniversitaireById(Long id) {
            formationUniversitaireRepository.deleteById(id);
        }
    }

    

