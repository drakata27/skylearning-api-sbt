package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.dto.LoginUserDto;
import org.aleksdraka.skylearningbackend.dto.RegisterUserDto;
import org.aleksdraka.skylearningbackend.model.User;
import org.aleksdraka.skylearningbackend.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User()
                .setFullName(input.getFullName())
                .setEmail(input.getEmail())
                .setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getEmail(),
                            input.getPassword()
                    )
            );
            return userRepository.findByEmail(input.getEmail())
                    .orElseThrow(); // Should handle this more gracefully
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed"); // Handle the exception more meaningfully
        }
    }
}