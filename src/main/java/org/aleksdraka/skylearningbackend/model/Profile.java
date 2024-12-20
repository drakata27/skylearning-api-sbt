package org.aleksdraka.skylearningbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @Column(name = "profileId", nullable = false, updatable = false)
    private String profileId;
    private String username;
    private String name;
    private String email;
}
