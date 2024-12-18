package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findBySectionId(Long id);

    Deck findBySectionIdAndDeckId(Long id, Long deckId);
    int countBySectionId(Long id);
}
