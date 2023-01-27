package com.nrk.yathra.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfiguration {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        // Permit All Requests inside the Web Application
        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers("/User/**").permitAll()
                .requestMatchers("/Post/**").permitAll().
                and().formLogin()
                .and().httpBasic();

        // Deny All Requests inside the Web Application
//            http.authorizeHttpRequests().anyRequest().denyAll().
//                    and().formLogin()
//                    .and().httpBasic();

        return http.build();

    }
}
