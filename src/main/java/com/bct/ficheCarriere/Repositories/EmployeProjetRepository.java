package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeProjetRepository extends JpaRepository<EmployeProjet,Long> {
    List<EmployeProjet> findAllByEmploye(Employe employe);
}
