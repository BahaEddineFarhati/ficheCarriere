package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.ModelPFE.Conference;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository  extends JpaRepository<Conference, Long> {
	 

}
