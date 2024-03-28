package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Projet;
import com.bct.ficheCarriere.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Projet")
public class ProjetController {

	   private ProjetService projetService;

        @Autowired
        public ProjetController(ProjetService projetService) {
            this.projetService = projetService;
        }

        @GetMapping("/getAll")
        public ResponseEntity<List<Projet>> getAllProjets() {
            List<Projet> projets = projetService.getAllProjets();
            return new ResponseEntity<>(projets, HttpStatus.OK);
        }

        @GetMapping("/getProjet/{id}")
        public ResponseEntity<Projet> getProjetById(@PathVariable("id") Long id) {
            return projetService.getProjetById(id)
                    .map(projet -> new ResponseEntity<>(projet, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping("/addProjet")
        public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
            Projet savedProjet = projetService.saveProjet(projet);
            return new ResponseEntity<>(savedProjet, HttpStatus.CREATED);
        }

        @PutMapping("/updateProjet/{id}")
        public ResponseEntity<Projet> updateProjet(@PathVariable("id") Long id, @RequestBody Projet projet) {
            if (!projetService.getProjetById(id).isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            projet.setId(id);
            Projet updatedProjet = projetService.saveProjet(projet);
            return new ResponseEntity<>(updatedProjet, HttpStatus.OK);
        }

        @DeleteMapping("/deleteProjet/{id}")
        public ResponseEntity<HttpStatus> deleteProjet(@PathVariable("id") Long id) {
            if (!projetService.getProjetById(id).isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            projetService.deleteProjetById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

