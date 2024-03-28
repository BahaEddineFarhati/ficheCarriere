package com.bct.ficheCarriere.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeGrade;
import com.bct.ficheCarriere.ModelPFE.Grade;
import com.bct.ficheCarriere.Repositories.EmployeRepository;
import com.bct.ficheCarriere.Repositories.GradeRepository;
import com.bct.ficheCarriere.service.EmployeGradeService;


@RestController
@RequestMapping("/EmployeGrade")
public class EmployeGradeController {


	    @Autowired
	    private EmployeGradeService employeGradeService ;

	    @Autowired
	    private EmployeRepository employeRepository;

	    @Autowired
	    private GradeRepository gradeRepository;


	    @GetMapping("/get/{id}")
	    public ResponseEntity<EmployeGrade> getEmployeGradeById(@PathVariable Long id) {
	        Optional<EmployeGrade> optionalEmployGrade = employeGradeService.getEmployeGrade(id);
	        return optionalEmployGrade.map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }


	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteEmployeGrade(@PathVariable Long id) {
	    	employeGradeService.deleteEmployeGrade(id);
	        return ResponseEntity.noContent().build();
	    }



	    @PostMapping("/set")
	    public ResponseEntity<String> assignEmployeToGrade(
	            @RequestParam Long employeId,
	            @RequestParam Long gradeId) {

	        // Retrieve employe and projet from repositories
	        Optional<Employe> optionalEmploye = employeRepository.findById(employeId);
	        Optional<Grade> optionalGrade = gradeRepository.findById(gradeId);

	        if (optionalEmploye.isEmpty() || optionalGrade.isEmpty()) {
	            return ResponseEntity.badRequest().body("Invalid employe or grade ID");
	        }

	        Employe employe = optionalEmploye.get();
	        Grade grade = optionalGrade.get();

	        // You can pass the assignmentDate if required by your service
	        employeGradeService.setEmployeGrade(employe,grade);

	        return ResponseEntity.ok("Employe assigned to grade successfully");
	    }
	}



