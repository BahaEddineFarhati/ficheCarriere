package com.bct.ficheCarriere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.ficheCarriere.Repositories.DepartementRepository;
@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

}
