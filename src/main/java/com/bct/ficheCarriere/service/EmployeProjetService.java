package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.ModelPFE.Employe;
import com.bct.ficheCarriere.ModelPFE.EmployeProjet;
import com.bct.ficheCarriere.ModelPFE.Projet;
import com.bct.ficheCarriere.Repositories.EmployeProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeProjetService {

    @Autowired
    private EmployeProjetRepository employeProjetRepository ;

    public void setEmployeProjet(Employe employe, Projet projet) {
        EmployeProjet employeProjet = new EmployeProjet();
        employeProjet.setEmploye(employe);
        employeProjet.setProjet(projet);
        employeProjetRepository.save(employeProjet);
    }

    public Optional<EmployeProjet> getEmployeProjet(Long id) {
        return employeProjetRepository.findById(id);
    }

    public void deleteEmployeProjet(Long id) {
        employeProjetRepository.deleteById(id);
    }


}
