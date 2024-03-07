package com.bct.ficheCarriere.service;


import com.bct.ficheCarriere.Repositories.ProjetEmployeKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetEmployeKeyService {

    @Autowired
    private ProjetEmployeKeyRepository projetEmployeKeyRepository ;
}
