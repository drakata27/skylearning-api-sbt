package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
