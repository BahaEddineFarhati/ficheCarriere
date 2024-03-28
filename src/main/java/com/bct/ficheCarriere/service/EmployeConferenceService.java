package com.bct.ficheCarriere.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bct.ficheCarriere.ModelPFE.Conference;
import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeConference;
import com.bct.ficheCarriere.Repositories.EmployeConferenceRepository;

@Service
public class EmployeConferenceService {
	
	    @Autowired
	    private EmployeConferenceRepository employeConferenceRepository ;

	    public void setEmployeConference(Employe employe, Conference conference) {
	    	EmployeConference employeConference = new EmployeConference();
	    	employeConference.setEmploye(employe);
	    	employeConference.setConference(conference);
	    	employeConferenceRepository.save(employeConference);
	    }

	    public Optional<EmployeConference> getEmployeConference(Long id) {
	        return employeConferenceRepository.findById(id);
	    }

	    public void deleteEmployeConference(Long id) {
	    	employeConferenceRepository.deleteById(id);
	    }


	}



