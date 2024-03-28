package com.bct.ficheCarriere.service;

import com.bct.ficheCarriere.ModelPFE.Publication;
import com.bct.ficheCarriere.Repositories.PublicationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {
 
    private PublicationRepository publicationRepository ;
  

        @Autowired
        public PublicationService(PublicationRepository publicationRepository) {
            this.publicationRepository = publicationRepository;
        }

        public List<Publication> getAllPublications() {
            return publicationRepository.findAll();
        }

        public Optional<Publication> getPublicationById(Long id) {
            return publicationRepository.findById(id);
        }

        public Publication savePublication(Publication publication) {
            return publicationRepository.save(publication);
        }

        public void deletePublicationById(Long id) {
            publicationRepository.deleteById(id);
        }
    }


