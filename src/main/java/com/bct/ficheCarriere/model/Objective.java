package com.bct.ficheCarriere.model;

public class Objective {
    private Long id;
    private String employeeId;
    private String shortTermGoal;
    private String developmentPlan;

    private String plannedTraining;

    public Objective() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getShortTermGoal() {
        return shortTermGoal;
    }

    public void setShortTermGoal(String shortTermGoal) {
        this.shortTermGoal = shortTermGoal;
    }

    public String getDevelopmentPlan() {
        return developmentPlan;
    }

    public void setDevelopmentPlan(String developmentPlan) {
        this.developmentPlan = developmentPlan;
    }

    public String getPlannedTraining() {
        return plannedTraining;
    }

    public void setPlannedTraining(String plannedTraining) {
        this.plannedTraining = plannedTraining;
    }
}
