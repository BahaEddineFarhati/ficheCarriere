package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.ModelPFE.Projet;
import com.bct.ficheCarriere.Repositories.ProjetRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository ;
    
        public ProjetService(ProjetRepository projetRepository) {
            this.projetRepository = projetRepository;
        }

        public List<Projet> getAllProjets() {
            return projetRepository.findAll();
        }

        public Optional<Projet> getProjetById(Long id) {
            return projetRepository.findById(id);
        }

        public Projet saveProjet(Projet projet) {
            return projetRepository.save(projet);
        }

        public void deleteProjetById(Long id) {
            projetRepository.deleteById(id);
        }
    }


