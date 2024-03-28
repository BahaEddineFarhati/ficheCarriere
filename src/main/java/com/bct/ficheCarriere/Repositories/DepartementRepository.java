package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Departement;
import com.bct.ficheCarriere.ModelPFE.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement ,Long> {
    Optional<Departement> findByabreviation(String name);
}
