package com.bct.ficheCarriere.Repositories;
import com.bct.ficheCarriere.ModelPFE.Departement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bct.ficheCarriere.ModelPFE.Employe;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
    @Query("SELECT e FROM Employe e ORDER BY e.Id ASC")
    List<Employe> findTopN(int limit);

    List<Employe> findBydepartement(Departement department, Pageable pageable);

}



