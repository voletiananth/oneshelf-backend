package edu.bu.oneshelf.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bu.oneshelf.auth.config.AuthenticationConstants;
import edu.bu.oneshelf.auth.dto.AuthenticationRequest;
import edu.bu.oneshelf.auth.dto.TokenResponse;
import edu.bu.oneshelf.auth.models.Role;
import edu.bu.oneshelf.auth.models.User;
import edu.bu.oneshelf.common.UnAuthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


@AllArgsConstructor
@Order(1)
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
        setFilterProcessesUrl(AuthenticationConstants.SIGN_IN_URL);

    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            AuthenticationRequest authenticationRequest = new ObjectMapper().readValue(request.getInputStream(), AuthenticationRequest.class);
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword(), new ArrayList<>()));
        } catch (InternalAuthenticationServiceException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new UnAuthorizedException("Invalid username or password");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
    String token = JWT.create().withSubject(((User) authResult.getPrincipal()).getUsername())
            .withClaim("role",authResult.getAuthorities().iterator().next().getAuthority())
            .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConstants.EXPIRATION_TIME))
            .sign(Algorithm.HMAC512(AuthenticationConstants.SECRET.getBytes()));

        TokenResponse tokenResponse = TokenResponse.builder().accessToken(token).role(((User) authResult.getPrincipal()).getRole()).build();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(tokenResponse));

    }
}
