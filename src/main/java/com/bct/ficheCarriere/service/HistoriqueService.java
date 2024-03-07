package com.bct.ficheCarriere.service;


import com.bct.ficheCarriere.Repositories.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository ;
}
