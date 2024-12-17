package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.model.Profile;
import org.aleksdraka.skylearningbackend.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

public void saveProfile(Profile profile) {
    if (profileRepository.existsByProfileId(profile.getProfileId())) {
        System.out.println("Profile with ID " + profile.getProfileId() + " already exists. Skipping save.");
        return;
    }
    profileRepository.save(profile);
}
}
