package org.aleksdraka.skylearningbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests.anyRequest().authenticated())
//                .oauth2Login(oauth2Login ->
//                    oauth2Login.defaultSuccessUrl("http://localhost:3000", true))
//                .logout(logout ->
//                        logout
//                                .logoutUrl("/oauth/logout")
//                                .logoutSuccessUrl("http://localhost:3000")
//                                .invalidateHttpSession(true)
//                                .deleteCookies("JSESSIONID"));
//        return http.build();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/sections/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/sections/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/sections/**").authenticated()
                        .anyRequest().authenticated())
                .oauth2Login(oauth2Login ->
                        oauth2Login.defaultSuccessUrl("http://localhost:3000", true))
                .logout(logout ->
                        logout
                                .logoutUrl("/oauth/logout")
                                .logoutSuccessUrl("http://localhost:3000")
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID"))
                .cors(Customizer.withDefaults());
        return http.build();
    }
}
