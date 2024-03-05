package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private String Direction;
    private String Service;

    @ManyToMany(mappedBy = "Conferences")
    private Set<Employe> Grades = new HashSet<>();




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
}
