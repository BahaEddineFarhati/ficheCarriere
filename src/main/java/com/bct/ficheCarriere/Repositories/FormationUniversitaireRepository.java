package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.FormationUniversitaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormationUniversitaireRepository extends JpaRepository<FormationUniversitaire , Long> {
    Optional<FormationUniversitaire> findBynomDuDiplome(String name);
}
