package org.aleksdraka.skylearningbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profile {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profileId", nullable = false, updatable = false)
    private Integer profileId;
    private String username;
    private String name;
    private String email;

    public Profile(Integer profileId, String username, String name, String email) {
        this.profileId = profileId;
        this.username = username;
        this.name = name;
        this.email = email;
    }
}
