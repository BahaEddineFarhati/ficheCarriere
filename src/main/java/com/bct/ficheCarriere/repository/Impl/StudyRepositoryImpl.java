package com.bct.ficheCarriere.repository.Impl;

import com.bct.ficheCarriere.model.Conference;
import com.bct.ficheCarriere.model.Function;
import com.bct.ficheCarriere.model.Publication;
import com.bct.ficheCarriere.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudyRepositoryImpl implements StudyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Publication> getEmployeePublications(String employeeId) {
        List<Map<String, Object>> publicationsRows = jdbcTemplate.queryForList(" select P.ID, P.PUBLICATIONLINK, P.PUBLICATIONNAME, P.PUBLICATIONDATE" + " from GRH.FCV_PUBLICATION P" + " where P.EMPLOYEEID = ?", employeeId);
        List<Publication> publications = new ArrayList<Publication>();
        for (Map<String, Object> publicationsRow : publicationsRows) {
            Publication publication = new Publication();
            publication.setId(Long.valueOf(String.valueOf(publicationsRow.get("id"))));
            publication.setPublicationDate(String.valueOf(publicationsRow.get("PUBLICATIONDATE")));
            publication.setPublicationName(String.valueOf(publicationsRow.get("PUBLICATIONNAME")));
            String link = String.valueOf(publicationsRow.get("PUBLICATIONLINK"));
            link = link.equals("null") ? "" : link;
            publication.setPublicationLink(link);
            publications.add(publication);
        }
        return publications;
    }


    @Override
    public void postPublication(Publication publication) {
        jdbcTemplate.update("INSERT INTO FCV_PUBLICATION(publicationName,publicationDate,publicationLink,employeeId)" +
                " values (?,?,?,?)", publication.getPublicationName(), publication.getPublicationDate(), publication.getPublicationLink(), publication.getEmployeeId());
    }

    @Override
    public void updatePublication(Publication publication) {
        jdbcTemplate.update("Update FCV_PUBLICATION set publicationName =? , publicationDate=?,publicationLink=? where id = ?"
                , publication.getPublicationName(), publication.getPublicationDate(), publication.getPublicationLink(), publication.getId());
    }

    @Override
    public void deletePublication(Long id) {
        jdbcTemplate.update("delete from FCV_PUBLICATION where id=?", id);
    }

    @Override
    public List<Conference> getEmployeeConferences(String employeeId) {
        List<Map<String, Object>> conferencesRows = jdbcTemplate.queryForList(" select C.ID, C.ConferenceName, C.ConferenceCountry, C.ConferenceDate, c.ConferenceSubject" + " from GRH.FCV_CONFERENCE C" + " where C.EMPLOYEEID = ?", employeeId);
        List<Conference> conferences = new ArrayList<Conference>();
        for (Map<String, Object> conferencesRow : conferencesRows) {
            Conference conference = new Conference();
            conference.setId(Long.valueOf(String.valueOf(conferencesRow.get("id"))));
            conference.setConferenceName(String.valueOf(conferencesRow.get("ConferenceName")));
            conference.setConferenceCountry(String.valueOf(conferencesRow.get("ConferenceCountry")));
            conference.setConferenceDate(String.valueOf(conferencesRow.get("ConferenceDate")));
            conference.setConferenceSubject(String.valueOf(conferencesRow.get("ConferenceSubject")));
            conferences.add(conference);


        }
        return conferences;
    }

    @Override
    public void postConference(Conference conference) {
        jdbcTemplate.update("INSERT INTO FCV_CONFERENCE (CONFERENCENAME,CONFERENCECOUNTRY,CONFERENCEDATE,CONFERENCESUBJECT,EMPLOYEEID) values (?,?,?,?,?) "
                , conference.getConferenceName(), conference.getConferenceCountry(), conference.getConferenceDate(),
                conference.getConferenceSubject(),conference.getEmployeeId());
    }

    @Override
    public void updateConference(Conference conference) {
        jdbcTemplate.update("Update FCV_CONFERENCE set CONFERENCENAME =? , CONFERENCECOUNTRY=?,CONFERENCEDATE=? , CONFERENCESUBJECT=? where id = ?"
                , conference.getConferenceName(), conference.getConferenceCountry(), conference.getConferenceDate(),
                conference.getConferenceSubject(), conference.getId());
    }

    @Override
    public void deleteConference(Long id) {
        jdbcTemplate.update("delete from FCV_CONFERENCE where id=?", id);
    }
}
