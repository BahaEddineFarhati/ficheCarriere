package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Fonction;
import com.bct.ficheCarriere.ModelPFE.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FonctionRepository extends JpaRepository<Fonction , Long> {
    Optional<Fonction> findBynom(String name);
}
