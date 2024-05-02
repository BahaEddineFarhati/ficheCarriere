package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur , String> {
    Optional<Utilisateur> findByUsername(String username);
    Boolean existsByUsername(String username);

    void deleteUtilisateurById(Long id);

}
