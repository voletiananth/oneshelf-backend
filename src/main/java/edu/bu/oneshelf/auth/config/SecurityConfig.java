package edu.bu.oneshelf.auth.config;

import edu.bu.oneshelf.auth.exceptions.AccessDeniedExceptionHandler;
import edu.bu.oneshelf.auth.filter.AuthenticationFilter;
import edu.bu.oneshelf.auth.filter.AuthorizationFilter;
import edu.bu.oneshelf.auth.models.Role;
import edu.bu.oneshelf.auth.services.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        AuthenticationManager authenticationManager = auth.build();
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/api/v1/auth/refresh/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/v1/client/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/v1/manager/**"))
                .hasAnyAuthority(Role.MANAGER.name(),Role.ADMIN.name())
                .anyRequest()
                .hasAuthority(Role.ADMIN.name())
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedExceptionHandler())
                .and()
                .authenticationManager(authenticationManager)
                .addFilter(new AuthenticationFilter(authenticationManager))
                .addFilterAfter(new AuthorizationFilter(authenticationManager,userDetailsService), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ;

        return http.build();

    }













}
