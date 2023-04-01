package edu.bu.oneshelf.auth.dto;


import edu.bu.oneshelf.auth.models.Role;
import lombok.*;

@Data()
@EqualsAndHashCode(callSuper = false)

public class TokenResponse extends AccessTokenResponse {



    @Builder
    TokenResponse(String accessToken, String refreshToken, Role role) {
        super(accessToken);
        this.refreshToken = refreshToken;
        this.role = role;
    }


    public String refreshToken;
    public Role role;
}
