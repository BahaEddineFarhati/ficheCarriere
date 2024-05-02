package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Historique;
import com.bct.ficheCarriere.ModelPFE.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueRepository extends JpaRepository<Historique , Long> {
    void deleteAllByUtilisateur(Utilisateur utilisateur);
}
