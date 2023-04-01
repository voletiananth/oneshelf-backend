package edu.bu.oneshelf.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import edu.bu.oneshelf.auth.config.AuthenticationConstants;
import edu.bu.oneshelf.auth.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class TokenUtils {

    public static String encodeAccessToken(UserDetails user) {
       return JWT.create().withSubject(user.getUsername())
                .withClaim("role",user.getAuthorities().iterator().next().getAuthority())
                .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConstants.ACCESS_EXPIRATION_TIME))
                .withIssuer(AuthenticationConstants.ACCESS_ISSUER)
                .sign(Algorithm.HMAC512(AuthenticationConstants.SECRET.getBytes()));
    }

    public static String encodeRefreshToken(UserDetails user){
       return  JWT.create().withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConstants.REFRESH_EXPIRATION_TIME))
                .withIssuer(AuthenticationConstants.REFRESH_ISSUER)
                .sign(Algorithm.HMAC384((AuthenticationConstants.SECRET + "refresh").getBytes()));
    }


    public static DecodedJWT decodeAccessToken(String token) {
        Algorithm algorithm = Algorithm.HMAC512(AuthenticationConstants.SECRET.getBytes());
        return JWT.require(algorithm)
                .withIssuer(AuthenticationConstants.ACCESS_ISSUER)
                .build()
                .verify(token.replace(AuthenticationConstants.TOKEN_PREFIX, ""));

    }




    public static String decodeRefreshToken(String token) {
        Algorithm algorithm = Algorithm.HMAC384((AuthenticationConstants.SECRET + "refresh").getBytes());
        return JWT.require(algorithm)
                .withIssuer(AuthenticationConstants.REFRESH_ISSUER)
                .build()
                .verify(token)
                .getSubject();
    }

}
