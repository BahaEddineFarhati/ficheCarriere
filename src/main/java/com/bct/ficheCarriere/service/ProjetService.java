package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.Repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository ;
}
