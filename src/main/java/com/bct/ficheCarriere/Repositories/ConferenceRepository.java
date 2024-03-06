package com.bct.ficheCarriere.Repositories;

import com.bct.ficheCarriere.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository  extends JpaRepository<Conference, Long> {

}
