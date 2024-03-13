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

import com.bct.ficheCarriere.ModelPFE.Grade;
import com.bct.ficheCarriere.Repositories.GradeRepository;

@RestController
@RequestMapping("/grades")

public class GradeController {
	
	    @Autowired
	    private GradeRepository gradeRepository;

	  
	    @PostMapping("/add")
	    public Grade addGrade(@RequestBody Grade grade) {
	        return gradeRepository.save(grade);
	    }

	 
	    @GetMapping("/all")
	    public List<Grade> getAllGrades() {
	        return gradeRepository.findAll();
	    }

	 
	    @GetMapping("/{id}")
	    public Optional<Grade> getGradeById(@PathVariable Long id) {
	        return gradeRepository.findById(id);
	    }

	   
	    @PutMapping("/{id}")
	    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade updatedGrade) {
	        updatedGrade.setId(id);
	        return gradeRepository.save(updatedGrade);
	    }

	   
	    @DeleteMapping("/{id}")
	    public void deleteGrade(@PathVariable Long id) {
	        gradeRepository.deleteById(id);
	    }
	}



