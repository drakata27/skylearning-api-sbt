package org.aleksdraka.skylearningbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SkylearningBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkylearningBackendApplication.class, args);
    }
}
