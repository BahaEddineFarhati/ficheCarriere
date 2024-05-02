package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.CompetencesClasses.CompetenceInformatique;
import com.bct.ficheCarriere.ModelPFE.CompetencesClasses.CompetenceTechnique;
import com.bct.ficheCarriere.ModelPFE.Conference;
import com.bct.ficheCarriere.ModelPFE.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceInformatiqueInterface extends JpaRepository<CompetenceInformatique, Long> {
}
