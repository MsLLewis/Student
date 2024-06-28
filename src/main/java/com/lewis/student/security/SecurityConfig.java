package com.lewis.student.security;

import com.lewis.student.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/students/create-student").hasRole("ADMIN")
                        .requestMatchers("/students/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/students/login")  //points to endpoint
                        .permitAll()
                        .defaultSuccessUrl("/students/all", true)  // Redirect to 'all' endpoint page on successful login
                )
                .logout(logout -> logout
                        .logoutUrl("/students/logout")
                        .logoutSuccessUrl("/students/login?logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()

                )
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(userDetailsService); // Set the custom UserDetailsService

        return http.build();
    }

}
