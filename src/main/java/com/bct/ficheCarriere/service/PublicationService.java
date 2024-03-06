package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.Repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository ;
}
