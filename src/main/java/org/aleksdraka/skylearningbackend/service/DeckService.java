package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.model.Deck;
import org.aleksdraka.skylearningbackend.repository.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {
    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public List<Deck> getAllDecks(Long id) {
        return deckRepository.findBySectionId(id);
    }
}
