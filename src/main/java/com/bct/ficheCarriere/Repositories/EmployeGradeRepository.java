package com.bct.ficheCarriere.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bct.ficheCarriere.ModelPFE.EmployeGrade;

@Repository

public interface EmployeGradeRepository extends JpaRepository<EmployeGrade,Long>{

}
