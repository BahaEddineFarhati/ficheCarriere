package com.bct.ficheCarriere.Controllers;

import com.bct.ficheCarriere.ModelPFE.*;
import com.bct.ficheCarriere.Repositories.*;
import com.bct.ficheCarriere.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;

    private final PasswordEncoder passwordEncoder;


    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final TokenRepository tokenRepository ;


    private final HistoriqueRepository historiqueRepository ;


    @Autowired
    public UtilisateurController(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService, TokenRepository tokenRepository, HistoriqueRepository historiqueRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.historiqueRepository = historiqueRepository;
    }

    @PostMapping("/admin/addUtilisateur")
    public ResponseEntity<String> addUtilisateur(@RequestBody Utilisateur utilisateur) {
        String encodedPassword = passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(encodedPassword);
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registration was successful");
    }


//    @PostMapping("/auth/register")
//    public ResponseEntity<String> register(@RequestBody Utilisateur userEntity) {
//        // Enhanced username check for clarity and consistency:
//        if (utilisateurRepository.findByUsername(userEntity.getUsername()).isPresent()) {
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }
//
//        // Secure password storage:
//        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
//
//
//
//
//
//        Utilisateur user = new Utilisateur();
//        user.setUsername(userEntity.getUsername());
//        user.setPassword(encodedPassword);
//        user.setRole(userEntity.getRole());
//        user.setDepartement(userEntity.getDepartement());
//        user.setFormationUniv(userEntity.getFormationUniv());
//        user.setFonction(userEntity.getFonction());
//        user.setFormation(userEntity.getFormation());
//
//        utilisateurRepository.save(user);
//
//        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
//    }
    
    @GetMapping("admin/getAll")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }


    @GetMapping("admin/getUtilisateur/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathVariable String id) {
        return utilisateurRepository.findById(id);
    }

    @PutMapping("admin/updateUtilisateur/{id}")
    public Utilisateur updateUtilisateur(@PathVariable String id, @RequestBody Utilisateur updatedUtilisateur) {
        updatedUtilisateur.setMatricule(id);
        return utilisateurRepository.save(updatedUtilisateur);
    }


    @DeleteMapping("admin/deleteUtilisateur/{id}")
    public void deleteUtilisateur(@PathVariable String id) {
        utilisateurRepository.deleteById(id);
    }


    @PostMapping("/auth/login")
    public AuthenticationResponse login (@RequestBody Utilisateur utilisateur , HttpServletRequest request){

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getUsername(), utilisateur.getPassword()));

            // Retrieve the user from repository
            Utilisateur user = utilisateurRepository.findByUsername(utilisateur.getUsername()).orElseThrow();

            // Generate JWT token
            String jwt = jwtService.generateToken(user);

            // Revoke all tokens by user if needed
            revokeAllTokenByUser(utilisateur);

            // Save the user token
            saveUserToken(jwt, user);

            String ip = request.getRemoteAddr();

            Historique historique = new Historique();
            historique.setUtilisateur(user); // Assuming userId exists in Historique
            historique.setDate(new Date()); // Capture the current login date
            historique.setAdresseIp(ip);
            historiqueRepository.save(historique);

            // Return authentication response with JWT token
            return new AuthenticationResponse(jwt, "User login was successful", user.getId());

    }


    @GetMapping("/auth/validate-token")
    public ResponseEntity<Integer> validateToken(@RequestParam("token") String token) {
        boolean t = tokenRepository.existsByToken(token);
        if(t) {
            return ResponseEntity.ok(0);
        }
        else {
            return ResponseEntity.ok(1);
        }
    }


    @GetMapping("/auth/GetUser")
    public Utilisateur GetUser(@RequestParam("token") String token) {
        String username = jwtService.extractUsername(token);

        return utilisateurRepository.findByUsername(username).orElseThrow();
    }







    private void saveUserToken(String jwt, Utilisateur user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }



    private void revokeAllTokenByUser(Utilisateur user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }


}
