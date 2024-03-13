package com.bct.ficheCarriere.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bct.ficheCarriere.ModelPFE.Conference;
import com.bct.ficheCarriere.Repositories.ConferenceRepository;

@RestController
@RequestMapping("/conferences")


public class ConferenceController {

	    @Autowired
	    private ConferenceRepository conferenceRepository;

	  
	    @GetMapping
	    public List<Conference> getAllConferences() {
	        return conferenceRepository.findAll();
	    }

	   
	    @GetMapping("/{id}")
	    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id) {
	        return conferenceRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	
	    @PostMapping
	    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
	        Conference savedConference = conferenceRepository.save(conference);
	        return ResponseEntity.ok(savedConference);
	    }

	   
	    @PutMapping("/{id}")
	    public ResponseEntity<Conference> updateConference(@PathVariable Long id, @RequestBody Conference conference) {
	        if (conferenceRepository.existsById(id)) {
	            conference.setId(id);
	            Conference updatedConference = conferenceRepository.save(conference);
	            return ResponseEntity.ok(updatedConference);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	  
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
	        if (conferenceRepository.existsById(id)) {
	            conferenceRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}



