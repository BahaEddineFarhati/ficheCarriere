package com.bct.ficheCarriere.ModelPFE;



import jakarta.persistence.*;



@Entity
@Table(name = "ConferenceEmployeKey")


public class ConferenceEmployeKey   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;
  

    @ManyToOne
    @JoinColumn(name = "matricule")
      private Employe employe;


    @ManyToOne
    @JoinColumn(name="idconference")
      private Conference conference;

}
