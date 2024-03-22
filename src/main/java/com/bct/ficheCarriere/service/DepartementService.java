package com.bct.ficheCarriere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.ficheCarriere.ModelPFE.Departement;
import com.bct.ficheCarriere.Repositories.DepartementRepository;
@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;
       
        public DepartementService(DepartementRepository departementRepository) {
            this.departementRepository = departementRepository;
        }

       
        public Departement createDepartement(Departement departement) {
            return departementRepository.save(departement);
        }

       
        public List<Departement> getAllDepartements() {
            return departementRepository.findAll();
        }

        public Optional<Departement> getDepartementById(Long id) {
            return departementRepository.findById(id);
        }

    
        public Departement updateDepartement(Long id, Departement updatedDepartement) {
            Departement departementToUpdate = departementRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Department with ID " + id + " not found"));
            departementToUpdate.setAbreviation(updatedDepartement.getAbreviation());
            departementToUpdate.setNom(updatedDepartement.getNom());
            return departementRepository.save(departementToUpdate);
        }

        
        public void deleteDepartementById(Long id) {
            departementRepository.deleteById(id);
        }
    }

    


