package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.Profile;
import org.aleksdraka.skylearningbackend.service.ProfileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    ProfileService profileService;

    public UserController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        Integer profileId = (Integer) principal.getAttributes().getOrDefault("id", "N/A");
        String username = (String) principal.getAttributes().getOrDefault("username", "N/A");
        String name = (String) principal.getAttributes().getOrDefault("name", "N/A");
        String email = (String) principal.getAttributes().getOrDefault("email", "N/A");
        profileService.saveProfile(new Profile(profileId, username, name, email ));

        return principal.getAttributes();
    }
}
