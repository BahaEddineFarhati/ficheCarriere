package com.bct.ficheCarriere.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeGrade;
import com.bct.ficheCarriere.ModelPFE.Grade;
import com.bct.ficheCarriere.Repositories.EmployeGradeRepository;

@Service
public class EmployeGradeService {
	

	    @Autowired
	    private EmployeGradeRepository employeGradeRepository ;

	    public void setEmployeGrade(Employe employe, Grade grade) {
	        EmployeGrade employeGrade = new EmployeGrade();
	        employeGrade.setEmploye(employe);
	        employeGrade.setGrade(grade);
	        employeGradeRepository.save(employeGrade);
	    }

	    public Optional<EmployeGrade> getEmployeGrade(Long id) {
	        return employeGradeRepository.findById(id);
	    }

	    public void deleteEmployeGrade(Long id) {
	    	employeGradeRepository.deleteById(id);
	    }


	}



