package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bct.ficheCarriere.ModelPFE.Formation;

import java.util.Optional;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    Optional<Formation> findBynom(String name);

}
