package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeProjet;
import com.bct.ficheCarriere.ModelPFE.Projet;
import com.bct.ficheCarriere.Repositories.EmployeRepository;
import com.bct.ficheCarriere.Repositories.ProjetRepository;
import com.bct.ficheCarriere.service.EmployeProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/EmployeProjet")
public class EmployeProjetController {

    @Autowired
    private EmployeProjetService employeProjetService;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private ProjetRepository projetRepository;


    @GetMapping("/{id}")
    public ResponseEntity<EmployeProjet> getEmployeProjetById(@PathVariable Long id) {
        Optional<EmployeProjet> optionalEmployeProjet = employeProjetService.getEmployeProjet(id);
        return optionalEmployeProjet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeProjet(@PathVariable Long id) {
        employeProjetService.deleteEmployeProjet(id);
        return ResponseEntity.noContent().build();
    }



    @PostMapping("/set")
    public ResponseEntity<String> assignEmployeToProjet(
            @RequestParam Long employeId,
            @RequestParam Long projetId) {

        // Retrieve employe and projet from repositories
        Optional<Employe> optionalEmploye = employeRepository.findById(employeId);
        Optional<Projet> optionalProjet = projetRepository.findById(projetId);

        if (optionalEmploye.isEmpty() || optionalProjet.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid employe or projet ID");
        }

        Employe employe = optionalEmploye.get();
        Projet projet = optionalProjet.get();

        // You can pass the assignmentDate if required by your service
        employeProjetService.setEmployeProjet(employe, projet);

        return ResponseEntity.ok("Employe assigned to projet successfully");
    }
}
