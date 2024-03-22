package com.bct.ficheCarriere.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.ficheCarriere.ModelPFE.Grade;
import com.bct.ficheCarriere.Repositories.GradeRepository;
@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    
        public GradeService(GradeRepository gradeRepository) {
            this.gradeRepository = gradeRepository;
        }

        
        public Grade addGrade(Grade grade) {
            return gradeRepository.save(grade);
        }

        public List<Grade> getAllGrades() {
            return gradeRepository.findAll();
        }

    
        public Optional<Grade> getGradeById(Long id) {
            return gradeRepository.findById(id);
        }

        
        public Grade updateGrade(Long id, Grade updatedGrade) {
            Grade gradeToUpdate = gradeRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Grade avec l'ID " + id + " non trouvé"));
            gradeToUpdate.setDate(updatedGrade.getDate());
            gradeToUpdate.setDirection(updatedGrade.getDirection());
            gradeToUpdate.setService(updatedGrade.getService());
            return gradeRepository.save(gradeToUpdate);
        }

        
        public void deleteGradeById(Long id) {
            gradeRepository.deleteById(id);
        }
    }


