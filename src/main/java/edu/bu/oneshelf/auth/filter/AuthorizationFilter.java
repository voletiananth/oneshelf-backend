package edu.bu.oneshelf.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import edu.bu.oneshelf.auth.config.AuthenticationConstants;
import edu.bu.oneshelf.auth.models.User;
import edu.bu.oneshelf.common.UnAuthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Order(2)
public class AuthorizationFilter extends BasicAuthenticationFilter {

    UserDetailsService userDetailsService;

    public AuthorizationFilter(AuthenticationManager authenticationManager,UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(AuthenticationConstants.HEADER_STRING);
        if (header == null || !header.startsWith(AuthenticationConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }


    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(AuthenticationConstants.HEADER_STRING);
        if (token != null) {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(AuthenticationConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(AuthenticationConstants.TOKEN_PREFIX, ""));
            if (decodedJWT.getExpiresAt().before(new java.util.Date())) {
                throw new UnAuthorizedException("Token Expired");
            }
            String username = decodedJWT.getSubject();
            String role = decodedJWT.getClaim("role").asString();

//            User user = (User) userDetailsService.loadUserByUsername(username);

            return new UsernamePasswordAuthenticationToken(username, null, getAuthorities(role));


        }
        return null;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority(role));
    }

}
