package org.aleksdraka.skylearningbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String subtitle;

    @Column(nullable = false)
    private String userId;

    @OneToMany(mappedBy = "section", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Note> notes;

    @OneToMany(mappedBy = "section", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Deck> decks;
}
