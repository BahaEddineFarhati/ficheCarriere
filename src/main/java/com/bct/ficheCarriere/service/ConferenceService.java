package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.ModelPFE.Conference;
import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.Repositories.ConferenceRepository;
import com.bct.ficheCarriere.Repositories.EmployeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ConferenceService {
	  @Autowired
	  private EmployeRepository EmployeRepository;
    private  ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    // Save or update a conference
    public Conference saveOrUpdateConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    // Retrieve a conference by its ID
    public Optional<Conference> getConferenceById(Long id) {
        return conferenceRepository.findById(id);
    }

    // Retrieve all conferences
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    // Delete a conference by its ID
    public void deleteConferenceById(Long id) {
        conferenceRepository.deleteById(id);
    }
    
  
   
   
    }
