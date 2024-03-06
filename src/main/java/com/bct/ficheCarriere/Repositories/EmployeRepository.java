package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, String> {

}
