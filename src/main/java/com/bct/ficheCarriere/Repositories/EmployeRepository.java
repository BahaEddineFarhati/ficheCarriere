package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Employe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
