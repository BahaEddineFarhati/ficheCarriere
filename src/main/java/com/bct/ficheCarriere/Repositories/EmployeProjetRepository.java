package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Departement;
import com.bct.ficheCarriere.ModelPFE.EmployeProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeProjetRepository extends JpaRepository<EmployeProjet,Long> {

}
