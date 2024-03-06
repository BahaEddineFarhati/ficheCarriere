package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.Repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository EmployeRepository;
}
