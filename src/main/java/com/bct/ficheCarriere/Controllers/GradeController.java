package com.bct.ficheCarriere.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bct.ficheCarriere.ModelPFE.Grade;
import com.bct.ficheCarriere.service.GradeService;

@RestController
@RequestMapping("/Grade")

public class GradeController {
	
	    @Autowired 
	    private final GradeService gradeService;

	        public GradeController(GradeService gradeService) {
	            this.gradeService = gradeService;
	        }

	        @PostMapping("/addGrade")
	        public ResponseEntity<Grade> addGrade(@RequestBody Grade grade) {
	            Grade savedGrade = gradeService.addGrade(grade);
	            return new ResponseEntity<>(savedGrade, HttpStatus.CREATED);
	        }

	        @GetMapping("/getAllGrades")
	        public ResponseEntity<List<Grade>> getAllGrades() {
	            List<Grade> grades = gradeService.getAllGrades();
	            return new ResponseEntity<>(grades, HttpStatus.OK);
	        }

	        @GetMapping("/getGrade/{id}")
	        public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
	            Optional<Grade> grade = gradeService.getGradeById(id);
	            return grade.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	        }

	        @PutMapping("/updateGrade/{id}")
	        public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade updatedGrade) {
	            Grade updated = gradeService.updateGrade(id, updatedGrade);
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        }

	        @DeleteMapping("/deleteGrade/{id}")
	        public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
	            gradeService.deleteGradeById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	    }

	  
	  