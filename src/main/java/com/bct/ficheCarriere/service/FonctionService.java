package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.ModelPFE.Fonction;
import com.bct.ficheCarriere.Repositories.FonctionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FonctionService {
    @Autowired
    FonctionRepository fonctionRepository;
    
      public FonctionService(FonctionRepository fonctionRepository) {
            this.fonctionRepository = fonctionRepository;
        }

        
        public Fonction createFonction(Fonction fonction) {
            return fonctionRepository.save(fonction);
        }


        public List<Fonction> getAllFonctions() {
            return fonctionRepository.findAll();
        }

      
        public Optional<Fonction> getFonctionById(Long id) {
            return fonctionRepository.findById(id);
        }

        
        public Fonction updateFonction(Long id, Fonction updatedFonction) {
            Fonction fonctionToUpdate = fonctionRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Fonction with ID " + id + " not found"));
            fonctionToUpdate.setDate(updatedFonction.getDate());
            fonctionToUpdate.setNom(updatedFonction.getNom());
            return fonctionRepository.save(fonctionToUpdate);
        }

       
        public void deleteFonctionById(Long id) {
            fonctionRepository.deleteById(id);
        }
    }

    


