package org.aleksdraka.skylearningbackend.config;

import org.aleksdraka.skylearningbackend.model.Profile;
import org.aleksdraka.skylearningbackend.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//    @Bean
    CommandLineRunner initDatabase(ProfileService profileService) {
        return _ -> {
            profileService.saveProfile(
                    new Profile(
                            1,
                            "drakata",
                            "Aleksandar Drakaliyski",
                            "aleks.draka02@gmail.com" )
            );

//            profileService.getAllProfiles().forEach(profile -> log.info("Preloaded {}", profile));
        };
    }
}
