package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
@Entity
public class ConferenceEmployeKey implements Serializable {

    @Id
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "matricule")
    private Employe employe;

    @ManyToOne()
    @JoinColumn(name="idconference")
    private Conference conference;

}
