package com.bct.ficheCarriere.repository;

import com.bct.ficheCarriere.model.Conference;
import com.bct.ficheCarriere.model.Publication;

import java.util.List;

public interface StudyRepository {
    List<Publication> getEmployeePublications(String employeeId);
    void postPublication(Publication publication);

    void updatePublication(Publication publication);

    void deletePublication(Long id);
    List<Conference> getEmployeeConferences(String employeeId);
    void postConference(Conference conference);
    void updateConference(Conference conference);
    void deleteConference(Long id);

}
