package org.aleksdraka.skylearningbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deckId", nullable = false, updatable = false)
    private Long deckId;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonBackReference
    private Section section;

    public Deck(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
