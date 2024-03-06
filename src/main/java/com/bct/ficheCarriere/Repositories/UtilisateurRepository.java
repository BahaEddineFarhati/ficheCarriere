package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur , String> {
}
