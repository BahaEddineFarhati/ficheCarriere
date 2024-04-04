package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.*;
import com.bct.ficheCarriere.ModelPFE.dto.EmployeBaseInformation;
import com.bct.ficheCarriere.ModelPFE.dto.EmployeBaseProfilinformation;
import com.bct.ficheCarriere.ModelPFE.dto.EmployeProjetInfo;
import com.bct.ficheCarriere.ModelPFE.dto.EmployeRhInfo;
import com.bct.ficheCarriere.Repositories.PublicationRepository;
import com.bct.ficheCarriere.Repositories.UtilisateurRepository;
import com.bct.ficheCarriere.service.EmployeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.jsonwebtoken.Jwts.*;

@RestController
@RequestMapping("/Employe")
public class EmployeesController {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    @Autowired
    private PublicationRepository publicationRepository;
   
    @PostMapping("/admin/addEmploye")
    public ResponseEntity<Employe> saveEmploye(@RequestBody Employe employe) {
        Employe savedEmploye = employeService.saveEmploye(employe);
        return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
    }

    @GetMapping("/admin/getAll")
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    @GetMapping("/admin/getEmploye/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Optional<Employe> employe = employeService.getEmployeById(id);
        return employe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/admin/deleteEmploye/{id}")
    public ResponseEntity<Void> deleteEmployeById(@PathVariable Long id) {
        employeService.deleteEmployeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/admin/updateEmploye/{employeId}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long employeId, @RequestBody Employe employeUpdates) {
        Employe updatedEmploye = employeService.updateEmploye(employeId, employeUpdates);
        return new ResponseEntity<>(updatedEmploye, HttpStatus.OK);
    }



    @GetMapping("/getEmployesInfoBase")
    public ResponseEntity<List<EmployeBaseInformation>> getEmployees(
            @RequestParam(defaultValue = "10") int limit) {
        // Retrieve employees from the database using the specified limit
        List<Employe> employees = employeService.getEmployeeswithlimit(limit);
        List<EmployeBaseInformation> employeeDTOs = employees.stream()
                .map(this::mapToEmployeeDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(employeeDTOs);
    }


    @GetMapping("/getEmployeInfoBaseDep")
    public ResponseEntity<List<EmployeBaseInformation>> getEmployees(
            @RequestParam(defaultValue = "10") int limit,
            Principal principal // Access user information
    ) {
        String username = principal.getName();
        Utilisateur user = utilisateurRepository.findByUsername(username).orElseThrow();

        Departement departement = user.getDepartement();

        // Retrieve employees from the database within the specified department and limit
        List<Employe> employees = employeService.getEmployeesByDepartmentWithLimit(departement, limit);

        List<EmployeBaseInformation> employeeDTOs = employees.stream()
                .map(this::mapToEmployeeDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(employeeDTOs);
    }



    @GetMapping("/getEmployeProfilBaseInfo/{id}")
    public ResponseEntity<EmployeBaseProfilinformation> getEmployeProfilBaseInfoById(@PathVariable Long id) {
        Employe employe = employeService.getEmployeById(id).orElseThrow();
        EmployeBaseProfilinformation emp = new EmployeBaseProfilinformation();

        List<Publication> publications = publicationRepository.findByEmploye(employe);

        emp.setMatricule(employe.getMatricule());
        emp.setNom(employe.getMatricule());
        emp.setPrenom(employe.getMatricule());
        emp.setImage(employe.getMatricule());
        emp.setEmail(employe.getEmail());
        emp.setNumeroTelephone(employe.getNumeroTelephone());
        emp.setDateDeNaissance(employe.getDateDeNaissance());
        emp.setAdresse(employe.getAdresse());
        emp.setFonction(employe.getFonction());
        emp.setFormationUniv(employe.getFormationUniv());
        emp.setDepartement(employe.getDepartement());
        emp.setPublications(publications);
        /*emp.setConferences(employe.getEmployeConference().stream()
                .map(EmployeConference::getConference)
                .collect(Collectors.toList()));*/

        return ResponseEntity.ok(emp);
    }






    @GetMapping("/getEmployeProjetInfo/{id}")
    public ResponseEntity<EmployeProjetInfo> getEmployeProjetInfoById(@PathVariable Long id) {
        Employe employe = employeService.getEmployeById(id).orElseThrow();
        EmployeProjetInfo emp = new EmployeProjetInfo();
        emp.setProjets(employe.getEmployeProjet().stream()
                .map(EmployeProjet::getProjet)
                .collect(Collectors.toList()));
        emp.setCompetences("Table Compétences NEKSAA !");
        emp.setResponsabilite(employe.getResponsabilite());
        emp.setFormations(employe.getFormations());

        return ResponseEntity.ok(emp);
    }



    @GetMapping("/getEmployeRhInfo/{id}")
    public ResponseEntity<EmployeRhInfo> getEmployeRhInfoById(@PathVariable Long id) {
        Employe employe = employeService.getEmployeById(id).orElseThrow();
        EmployeRhInfo emp = new EmployeRhInfo();
        emp.setGrades(employe.getEmployeGrade().stream()
                .map(EmployeGrade::getGrade)
                .collect(Collectors.toList()));
        emp.setCompetences("Table Compétences NEKSAA !");
        emp.setResponsabilite(employe.getResponsabilite());
        emp.setFormations(employe.getFormations());
        emp.setId(employe.getId());
        emp.setConferences(employe.getEmployeConference().stream()
                .map(EmployeConference::getConference)
                .collect(Collectors.toList()));
        emp.setRecompenceEtReconnaissance(employe.getRecompenceEtReconnaissance());
        emp.setDisponibilitePourDesChangementsDePoste(employe.getDisponibilitePourDesChangementsDePoste());
        emp.setDisponibilitePourDesDeplacements(employe.getDisponibilitePourDesDeplacements());
        emp.setDisponibilitePourDesMissionALEtranger(employe.getDisponibilitePourDesMissionALEtranger());
        emp.setNivLangue("Att nivLangue Nekes !");
        return ResponseEntity.ok(emp);
    }






    private Departement getDepartmentForUser(Principal principal) {
        Utilisateur user = (Utilisateur) principal; // Assuming Principal provides access to a User object
        return user.getDepartement();
    }


    private EmployeBaseInformation mapToEmployeeDTO(Employe employe) {
        EmployeBaseInformation employeeDTO = new EmployeBaseInformation();
        employeeDTO.setId(employe.getId());
        employeeDTO.setMatricule(employe.getMatricule());
        employeeDTO.setNom(employe.getNom());
        employeeDTO.setPrenom(employe.getPrenom());
        employeeDTO.setFonction(employe.getFonction());
        employeeDTO.setDepartement(employe.getDepartement());
        // Map other fields if needed
        return employeeDTO;
    }










}
    
    
   
    
    

