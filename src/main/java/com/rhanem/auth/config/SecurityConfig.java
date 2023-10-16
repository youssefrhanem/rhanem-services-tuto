package com.rhanem.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().
                requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/notice","/contact","/h2-console/**")
                        .permitAll()
                .requestMatchers("/MyAccount","/MyBalance","/MLoans","/MyCards")
                .hasAnyRole("")
                .anyRequest()
                .authenticated()

        );
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());


        return http.build();
    }




   // @Bean
   // public PasswordEncoder passwordEncoder(){
        //return new BCryptPasswordEncoder();
   // }
}
