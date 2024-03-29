package com.bct.ficheCarriere.ModelPFE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Data
public class AuthenticationResponse {
    private String token;
    private String message;
    private Long user_id;

    public AuthenticationResponse(String token, String message ,Long user_id) {
        this.token = token;
        this.message = message;
        this.user_id = user_id;
    }

}