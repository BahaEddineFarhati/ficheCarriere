package com.bct.ficheCarriere.ModelPFE;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private Integer id;

    private String token;

    private boolean loggedOut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur user;

}