package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet , Long> {
}
