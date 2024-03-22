package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Conference;
import com.bct.ficheCarriere.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Conference")
public class ConferenceController {
	   @Autowired
    private  ConferenceService conferenceService;


    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }
    @GetMapping("/getConference/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id) {
        Optional<Conference> conference = conferenceService.getConferenceById(id);
        return conference.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   @GetMapping("/getAll")
    public ResponseEntity<List<Conference>> getAllConferences() {
        List<Conference> conferences = conferenceService.getAllConferences();
        return new ResponseEntity<>(conferences, HttpStatus.OK);
    }

    // Endpoint to create or update a conference
    @PostMapping("/addConference")
    public ResponseEntity<Conference> saveOrUpdateConference(@RequestBody Conference conference) {
        Conference savedConference = conferenceService.saveOrUpdateConference(conference);
        return new ResponseEntity<>(savedConference, HttpStatus.CREATED);
    }

    // Endpoint to delete a conference by its ID
    @DeleteMapping("/deleteConference/{id}")
    public ResponseEntity<Void> deleteConferenceById(@PathVariable Long id) {
        conferenceService.deleteConferenceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   
}