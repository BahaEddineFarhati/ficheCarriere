package com.bct.ficheCarriere.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bct.ficheCarriere.ModelPFE.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
}



