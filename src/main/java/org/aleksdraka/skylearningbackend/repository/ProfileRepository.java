package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByProfileId(Integer profileId);
}
