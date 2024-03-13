package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Publication;
import com.bct.ficheCarriere.Repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    @Autowired
    private PublicationRepository publicationRepository;


    @PostMapping("/add")
    public Publication addPublication(@RequestBody Publication publication) {
        return publicationRepository.save(publication);
    }

   
    @GetMapping("/all")
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

   
    @GetMapping("/{id}")
    public Optional<Publication> getPublicationById(@PathVariable Long id) {
        return publicationRepository.findById(id);
    }


    @PutMapping("/{id}")
    public Publication updatePublication(@PathVariable Long id, @RequestBody Publication updatedPublication) {
        updatedPublication.setId(id);
        return publicationRepository.save(updatedPublication);
    }

  
    @DeleteMapping("/{id}")
    public void deletePublication(@PathVariable Long id) {
        publicationRepository.deleteById(id);
    }
}
