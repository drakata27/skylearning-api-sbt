package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
