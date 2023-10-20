package com.udemycourse.springboot.learnspringbootjpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author bibek
 */
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //Auth all requests
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // Add web page pop up for entering username password
        httpSecurity.httpBasic(Customizer.withDefaults());

        //Disable http csrf, it restricts post & put request, hence need to disable
//        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
