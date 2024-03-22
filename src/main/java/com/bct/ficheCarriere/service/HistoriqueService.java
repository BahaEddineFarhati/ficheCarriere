package com.bct.ficheCarriere.service;


import com.bct.ficheCarriere.ModelPFE.Historique;
import com.bct.ficheCarriere.Repositories.HistoriqueRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository ;
    
        public HistoriqueService(HistoriqueRepository historiqueRepository) {
            this.historiqueRepository = historiqueRepository;
        }

  
        public Historique createHistorique(Historique historique) {
            return historiqueRepository.save(historique);
        }

      
        public List<Historique> getAllHistoriques() {
            return historiqueRepository.findAll();
        }

   
        public Optional<Historique> getHistoriqueById(Long id) {
            return historiqueRepository.findById(id);
        }

    
        public Historique updateHistorique(Long id, Historique updatedHistorique) {
            Historique historiqueToUpdate = historiqueRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Historique avec l'ID " + id + " non trouvé"));
            historiqueToUpdate.setDate(updatedHistorique.getDate());
            historiqueToUpdate.setUtilisateur(updatedHistorique.getUtilisateur());
            return historiqueRepository.save(historiqueToUpdate);
        }

      
        public void deleteHistoriqueById(Long id) {
            historiqueRepository.deleteById(id);
        }
    }

    

