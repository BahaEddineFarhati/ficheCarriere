/*package com.bct.ficheCarriere.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bct.ficheCarriere.model.Employee;
import com.bct.ficheCarriere.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeesController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/listEmployees")
    public String getEmployeesList(Model model) {
		
		List<Employee> listEmployees = employeeRepo.getEmployeesList();
		model.addAttribute("listEmployees",listEmployees);
		model.addAttribute("listDepartments",employeeRepo.getDepartmentsList());
		model.addAttribute("listFunctions",employeeRepo.getFunctionsList());
    
    	
       return "listEmployees";
    
    
    }

}
*/