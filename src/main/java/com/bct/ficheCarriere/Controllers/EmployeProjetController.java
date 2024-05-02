package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeProjet;
import com.bct.ficheCarriere.ModelPFE.Projet;
import com.bct.ficheCarriere.ModelPFE.dto.EmployeProjetDTO;
import com.bct.ficheCarriere.Repositories.EmployeProjetRepository;
import com.bct.ficheCarriere.Repositories.EmployeRepository;
import com.bct.ficheCarriere.Repositories.ProjetRepository;
import com.bct.ficheCarriere.service.EmployeProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/EmployeProjet")
public class EmployeProjetController {

    @Autowired
    private EmployeProjetService employeProjetService;

    @Autowired
    private EmployeProjetRepository employeProjetRepository;

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


    @GetMapping("/dto/{id}")
    public ResponseEntity<List<EmployeProjetDTO>> getById(@PathVariable Long id) {
        Employe emp = employeRepository.findById(id).orElseThrow();
        List<EmployeProjet> L_empProjet = employeProjetRepository.findAllByEmploye(emp);

        List<EmployeProjetDTO> dtos = L_empProjet.stream().map(empProjet -> {
            Projet projet = projetRepository.findById(empProjet.getProjet().getId()).orElseThrow();

            EmployeProjetDTO dto = new EmployeProjetDTO();
            dto.setId(empProjet.getId());
            dto.setNom(projet.getNom());
            dto.setDate(projet.getDate());
            dto.setRoleProjet(empProjet.getRoleProjet());
            dto.setDescription(projet.getDescription());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
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
