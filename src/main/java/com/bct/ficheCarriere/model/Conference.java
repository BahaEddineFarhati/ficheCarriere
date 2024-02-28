package com.bct.ficheCarriere.model;

public class Conference {

    private Long id;
    private String conferenceName;
    private String conferenceCountry;

    private String conferenceDate;

    private String conferenceSubject;

    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Conference() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceCountry() {
        return conferenceCountry;
    }

    public void setConferenceCountry(String conferenceCountry) {
        this.conferenceCountry = conferenceCountry;
    }

    public String getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(String conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public String getConferenceSubject() {
        return conferenceSubject;
    }

    public void setConferenceSubject(String conferenceSubject) {
        this.conferenceSubject = conferenceSubject;
    }
}
