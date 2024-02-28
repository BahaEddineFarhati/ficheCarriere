package com.bct.ficheCarriere.repository;

import java.util.List;



import com.bct.ficheCarriere.model.Employee;


public interface EmployeeRepository {
	List<Employee> getEmployeesList ();
	List<String> getDepartmentsList();
	List<String> getFunctionsList();

}
