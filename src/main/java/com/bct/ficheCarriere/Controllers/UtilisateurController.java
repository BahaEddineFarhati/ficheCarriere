package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.*;
import com.bct.ficheCarriere.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;

    private final PasswordEncoder passwordEncoder;


    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository ;

    private final DepartementRepository departementRepository ;

    private final FonctionRepository fonctionRepository ;

    private final FormationRepository formationRepository ;

    private final FormationUniversitaireRepository formationUniversitaireRepository ;


    @Autowired
    public UtilisateurController(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, RoleRepository roleRepository, DepartementRepository departementRepository, FonctionRepository fonctionRepository, FormationRepository formationRepository, FormationUniversitaireRepository formationUniversitaireRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.departementRepository = departementRepository;
        this.fonctionRepository = fonctionRepository;
        this.formationRepository = formationRepository;
        this.formationUniversitaireRepository = formationUniversitaireRepository;
    }

    @PostMapping("/auth/addUtilisateur")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        String encodedPassword = passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(encodedPassword);
        return utilisateurRepository.save(utilisateur);
    }


    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody Utilisateur userEntity) {
        // Enhanced username check for clarity and consistency:
        if (utilisateurRepository.findByUsername(userEntity.getUsername()).isPresent()) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // Secure password storage:
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());





        Utilisateur user = new Utilisateur();
        user.setUsername(userEntity.getUsername());
        user.setPassword(encodedPassword);
        user.setRole(userEntity.getRole());
        user.setDepartement(userEntity.getDepartement());
        user.setFormationUniv(userEntity.getFormationUniv());
        user.setFonction(userEntity.getFonction());
        user.setFormation(userEntity.getFormation());

        utilisateurRepository.save(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }
    
    @GetMapping("/getAll")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }


    @GetMapping("/getUtilisateur/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathVariable String id) {
        return utilisateurRepository.findById(id);
    }

    @PutMapping("/updateUtilisateur/{id}")
    public Utilisateur updateUtilisateur(@PathVariable String id, @RequestBody Utilisateur updatedUtilisateur) {
        updatedUtilisateur.setMatricule(id);
        return utilisateurRepository.save(updatedUtilisateur);
    }


    @DeleteMapping("/deleteUtilisateur/{id}")
    public void deleteUtilisateur(@PathVariable String id) {
        utilisateurRepository.deleteById(id);
    }


    @PostMapping("/auth/login")
    public ResponseEntity<String> login (@RequestBody Utilisateur utilisateur){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getUsername(),utilisateur.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User Signed Success !" , HttpStatus.OK);
    }



}
