package com.bct.ficheCarriere.model;

public class Training {
    Long id;
    String trainingType;
    String trainingDescription;
    String trainingBeginDate;
    String trainingEndDate;
    String employeeId;

    public Training() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTrainingBeginDate() {
        return trainingBeginDate;
    }

    public void setTrainingBeginDate(String trainingBeginDate) {
        this.trainingBeginDate = trainingBeginDate;
    }

    public String getTrainingEndDate() {
        return trainingEndDate;
    }

    public void setTrainingEndDate(String trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }
}
