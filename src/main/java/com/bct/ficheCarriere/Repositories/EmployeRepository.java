package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee, String> {

}
