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
public class FlashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cardId", nullable = false, updatable = false)
    private Long cardId;
    private String question;
    private String answer;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonBackReference
    private Deck deck;

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
