package org.aleksdraka.skylearningbackend.config;

import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.service.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(SectionService sectionService) {
        return _ -> {
            sectionService.saveSection(new Section("User ID Test","Google Account", "107411559235337526170"));
//            sectionService.saveSection(new Section("Java Notes","My notes"));
//            sectionService.saveSection(new Section("Python Notes","Python Notes"));

//            sectionService.getAllSections().forEach(section -> log.info("Preloaded {}", section));
        };
    }
}
