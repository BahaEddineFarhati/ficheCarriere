package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.model.EmployeeDetails;
import com.bct.ficheCarriere.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class EmployeeDetailsService {

    @Autowired
    EmployeeDetailsRepository employeeDetailsRepo;
    public EmployeeDetails getEmployeeDetails(String id){
        return employeeDetailsRepo.getEmployeeDetails(id);

    }

    public String getImagePath(String id){
        InputStream pngStream = getClass().getClassLoader().getResourceAsStream("static/assets/img/photos/" + id + ".png");

        System.out.println(pngStream);
        if (pngStream != null) {
            return "/assets/img/photos/" + id + ".png";
        }  else {
            return "/assets/img/photos/default.png";
        }
    }
}
