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

import com.bct.ficheCarriere.ModelPFE.Conference;
import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeConference;
import com.bct.ficheCarriere.Repositories.ConferenceRepository;
import com.bct.ficheCarriere.Repositories.EmployeRepository;
import com.bct.ficheCarriere.service.EmployeConferenceService;

@RestController
@RequestMapping("/EmployeConference")
public class EmployeConferenceController {
	
	    @Autowired
	    private EmployeConferenceService employeConferenceService;

	    @Autowired
	    private EmployeRepository employeRepository;

	    @Autowired
	    private ConferenceRepository conferenceRepository;


	    @GetMapping("/{id}")
	    public ResponseEntity<EmployeConference> getEmployeConferenceById(@PathVariable Long id) {
	        Optional<EmployeConference> optionalEmployeConference = employeConferenceService.getEmployeConference(id);
	        return optionalEmployeConference.map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }


	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployeProjet(@PathVariable Long id) {
	        employeConferenceService.deleteEmployeConference(id);
	        return ResponseEntity.noContent().build();
	    }



	    @PostMapping("/set")
	    public ResponseEntity<String> assignEmployeToConference(
	            @RequestParam Long employeId,
	            @RequestParam Long conferenceId) {

	        // Retrieve employe and projet from repositories
	        Optional<Employe> optionalEmploye = employeRepository.findById(employeId);
	        Optional<Conference> optionalConference = conferenceRepository.findById(conferenceId);

	        if (optionalEmploye.isEmpty() || optionalConference.isEmpty()) {
	            return ResponseEntity.badRequest().body("Invalid employe or conference ID");
	        }

	        Employe employe = optionalEmploye.get();
	       Conference conference = optionalConference.get();

	        // You can pass the assignmentDate if required by your service
	        employeConferenceService.setEmployeConference(employe, conference);

	        return ResponseEntity.ok("Employe assigned to conference successfully");
	    }
	}



