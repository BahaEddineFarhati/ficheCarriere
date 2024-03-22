package com.bct.ficheCarriere.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bct.ficheCarriere.ModelPFE.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

}
