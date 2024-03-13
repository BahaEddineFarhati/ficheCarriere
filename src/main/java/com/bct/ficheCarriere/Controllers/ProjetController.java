package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Projet;
import com.bct.ficheCarriere.Repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;

  
    @PostMapping("/add")
    public Projet addProjet(@RequestBody Projet projet) {
        return projetRepository.save(projet);
    }

  
    @GetMapping("/all")
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

  
    @GetMapping("/{id}")
    public Optional<Projet> getProjetById(@PathVariable Long id) {
        return projetRepository.findById(id);
    }

   
    @PutMapping("/{id}")
    public Projet updateProjet(@PathVariable Long id, @RequestBody Projet updatedProjet) {
        updatedProjet.setId(id);
        return projetRepository.save(updatedProjet);
    }


    @DeleteMapping("/{id}")
    public void deleteProjet(@PathVariable Long id) {
        projetRepository.deleteById(id);
    }
}
