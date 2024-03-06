package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade , Long> {
}
