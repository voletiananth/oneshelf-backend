package edu.bu.oneshelf.auth.dto;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import edu.bu.oneshelf.auth.TokenUtils;
import edu.bu.oneshelf.auth.config.AuthenticationConstants;
import edu.bu.oneshelf.common.UnAuthorizedException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RefreshTokenRequest {

    @NotBlank(message = "Refresh token is required")
    @NotEmpty(message = "Refresh token is required")
    public String refreshToken;

    public String getUsername() {
       try {
              return TokenUtils.decodeRefreshToken(refreshToken);
       }
         catch (Exception e) {
                 throw  new  UnAuthorizedException("Invalid refresh token");
         }
    }
}
