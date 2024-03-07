package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String Direction;
    private String Service;


    public Grade() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public Grade(Date date, String direction, String service) {
        this.date = date;
        Direction = direction;
        Service = service;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", date=" + date +
                ", Direction='" + Direction + '\'' +
                ", Service='" + Service + '\'' +
                '}';
    }
    @OneToMany()
    private ArrayList<GradeEmployeKey> employe;
}
