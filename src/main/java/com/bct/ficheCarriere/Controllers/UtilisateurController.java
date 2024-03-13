package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Utilisateur;
import com.bct.ficheCarriere.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @PostMapping("/add")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    
    @GetMapping("/all")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

  
    @GetMapping("/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathVariable String id) {
        return utilisateurRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable String id, @RequestBody Utilisateur updatedUtilisateur) {
        updatedUtilisateur.setMatricule(id);
        return utilisateurRepository.save(updatedUtilisateur);
    }


    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable String id) {
        utilisateurRepository.deleteById(id);
    }
}
