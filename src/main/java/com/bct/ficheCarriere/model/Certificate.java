package com.bct.ficheCarriere.model;

public class Certificate {
    Long id;
    String certifTitle;
    String certifDescription;
    String certifDate;
    String employeeId;

    public Certificate() {
    }

    public Long getId() {
        return id;
    }

    public String getCertifTitle() {
        return certifTitle;
    }

    public void setCertifTitle(String certifTitle) {
        this.certifTitle = certifTitle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertifDescription() {
        return certifDescription;
    }

    public void setCertifDescription(String certifDescription) {
        this.certifDescription = certifDescription;
    }

    public String getCertifDate() {
        return certifDate;
    }

    public void setCertifDate(String certifDate) {
        this.certifDate = certifDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
