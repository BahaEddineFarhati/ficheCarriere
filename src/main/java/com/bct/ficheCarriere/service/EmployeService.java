package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.Repositories.EmployeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EmployeService {

    @Autowired
    private EmployeRepository EmployeRepository;
  

        public Employe saveEmploye(Employe employe) {
            return EmployeRepository.save(employe);
        }

        public List<Employe> getAllEmployes() {
            return EmployeRepository.findAll();
        }

        public Optional<Employe> getEmployeById(Long id) {
            return EmployeRepository.findById(id);
        }

        public void deleteEmployeById(Long id) {
        	EmployeRepository.deleteById(id);
        }

        public Employe updateEmploye(Long employeId, Employe employeUpdates) {
                Optional<Employe> optionalEmploye = EmployeRepository.findById(employeId);

                if (optionalEmploye.isPresent()) {
                    Employe existingEmploye = optionalEmploye.get();
                    
                    // Update only non-null properties
                    BeanUtils.copyProperties(employeUpdates, existingEmploye, "id");
                    
                    // Save the updated employe
                    return EmployeRepository.save(existingEmploye);
                } else {
                    // Handle the case where the employe with the given ID is not found
                    throw new RuntimeException("Employe not found with id: " + employeId);
                }
            
        }
        
        
        
        public Optional<Employe> getEmployeeWithConferences(Long employeeId) {
            return EmployeRepository.findById(employeeId)
                    .map(employee -> {
                        employee.getConferences().size(); // Fetch conferences eagerly
                        return employee;
                    });
        }


    public List<Employe> getEmployeeswithlimit(int limit) {
        // Retrieve employees from the database with the specified limit
        return EmployeRepository.findTopN(limit);
    }
        
        
        
      
    }

    

