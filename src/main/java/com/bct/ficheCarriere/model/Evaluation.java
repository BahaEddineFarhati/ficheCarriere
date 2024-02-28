package com.bct.ficheCarriere.model;

public class Evaluation {
    private Long id;
    private String employeeId;

    private String evaluationSummary;

    private String supFeedback;

    private String colFeedback;

    private String strengths;

    private String amelioration;

    public Evaluation() {
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

    public String getEvaluationSummary() {
        return evaluationSummary;
    }

    public void setEvaluationSummary(String evaluationSummary) {
        this.evaluationSummary = evaluationSummary;
    }

    public String getSupFeedback() {
        return supFeedback;
    }

    public void setSupFeedback(String supFeedback) {
        this.supFeedback = supFeedback;
    }

    public String getColFeedback() {
        return colFeedback;
    }

    public void setColFeedback(String colFeedback) {
        this.colFeedback = colFeedback;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getAmelioration() {
        return amelioration;
    }

    public void setAmelioration(String amelioration) {
        this.amelioration = amelioration;
    }
}
