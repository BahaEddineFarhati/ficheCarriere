package com.bct.ficheCarriere.Controllers;

import java.util.List;

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

import com.bct.ficheCarriere.ModelPFE.Publication;
import com.bct.ficheCarriere.service.PublicationService;

@RestController
@RequestMapping("/Publication")
public class PublicationController {
	 @Autowired
    private final PublicationService publicationService;

   
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Publication>> getAllPublications() {
        List<Publication> publications = publicationService.getAllPublications();
        return new ResponseEntity<>(publications, HttpStatus.OK);
    }

    @GetMapping("//getPublication/{id}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable("id") Long id) {
        return publicationService.getPublicationById(id)
                .map(publication -> new ResponseEntity<>(publication, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addPublication")
    public ResponseEntity<Publication> createPublication(@RequestBody Publication publication) {
        Publication savedPublication = publicationService.savePublication(publication);
        return new ResponseEntity<>(savedPublication, HttpStatus.CREATED);
    }

    @PutMapping("/updatePublication/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable("id") Long id, @RequestBody Publication publication) {
        if (!publicationService.getPublicationById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        publication.setId(id);
        Publication updatedPublication = publicationService.savePublication(publication);
        return new ResponseEntity<>(updatedPublication, HttpStatus.OK);
    }

    @DeleteMapping("/deletePublication/{id}")
    public ResponseEntity<HttpStatus> deletePublication(@PathVariable("id") Long id) {
        if (!publicationService.getPublicationById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        publicationService.deletePublicationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


