package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {
    List<FlashCard> findByDeckDeckId(Long deckId);
}
