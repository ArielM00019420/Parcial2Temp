package com.grupo10.parcial2clinica.config;

import com.grupo10.parcial2clinica.domain.entities.User;
import com.grupo10.parcial2clinica.services.UserService;
import com.grupo10.parcial2clinica.utils.JWTTokenFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final UserService userService;

    @Autowired
    public WebSecurityConfiguration(UserService userService){
        this.userService =  userService;
    }

    @Autowired
    private JWTTokenFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Http login and cors disabled
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        // Route filter
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/*").permitAll()
                //agrego una ruta mas para ser implementada sin token
                .requestMatchers("/api/auth/register").permitAll()
                .anyRequest().authenticated());
//
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // UnAunthorized handler
        http.exceptionHandling(handling -> handling.authenticationEntryPoint((req, res, ex) -> {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Auth fail!");
        }));

        // JWT filter
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder managerBuilder
                = http.getSharedObject(AuthenticationManagerBuilder.class);

        managerBuilder
                .userDetailsService(identifier -> {
                    User user = userService.findByIdentifier(identifier);

                    if(user == null)
                        throw new UsernameNotFoundException("User: " + identifier + ", not found!");

                    return user;
                })
                .passwordEncoder(passwordEncoder());

        return managerBuilder.build();
    }
}
