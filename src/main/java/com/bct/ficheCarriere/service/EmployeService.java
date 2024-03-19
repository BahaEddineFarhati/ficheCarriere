package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.Repositories.EmployeRepository;

import java.util.List;
import java.util.Optional;

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

        public Employe updateEmploye(Employe employe) {
            return EmployeRepository.save(employe);
        }
        
        
        public Optional<Employe> getEmployeeWithConferences(Long employeeId) {
            return EmployeRepository.findById(employeeId)
                    .map(employee -> {
                        employee.getConferences().size(); // Fetch conferences eagerly
                        return employee;
                    });
        }
        
        
        
      
    }

    

