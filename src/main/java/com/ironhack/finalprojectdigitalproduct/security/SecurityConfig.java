package com.ironhack.finalprojectdigitalproduct.security;

import com.ironhack.finalprojectdigitalproduct.filter.CustomAuthenticationFilter;
import com.ironhack.finalprojectdigitalproduct.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private AuthenticationManagerBuilder authManagerBuilder;

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CustomAuthenticationFilter instance created
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authManagerBuilder.getOrBuild());
        // set the URL that the filter should process
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        // disable CSRF protection
        http.csrf().disable();
        // set the session creation policy to stateless
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        // set up authorization for different request matchers and user roles
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/login/**").permitAll()
                .requestMatchers(
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()
                .requestMatchers(POST,
                        "/api/v1/auth/**",
                        "/api/v1/**"
                ).hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER")
                .requestMatchers(GET,
                        "/api/v1/**",
                        "/api/v1/auth/**",
                        "/api/v1/greet",
                        "/api/v1/greet/admin"
                ).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN","ROLE_MANAGER")
                .requestMatchers(PUT,
                        "/api/v1/auth/**",
                        "/api/v1/**"
                ).hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER")
                .requestMatchers(PATCH,
                        "/api/v1/auth/**",
                        "/api/v1/**"
                ).hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER")
                .requestMatchers(DELETE,
                        "/api/v1/auth/**",
                        "/api/v1/**"
                ).hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER")
                .anyRequest().authenticated());
        // add the custom authentication filter to the http security object
        http.addFilter(customAuthenticationFilter);
        // Add the custom authorization filter before the standard authentication filter.
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        // Build the security filter chain to be returned.
        return http.build();
    }
}