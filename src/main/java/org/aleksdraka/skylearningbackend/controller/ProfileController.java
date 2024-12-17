package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.Profile;
import org.aleksdraka.skylearningbackend.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public List<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }
}
