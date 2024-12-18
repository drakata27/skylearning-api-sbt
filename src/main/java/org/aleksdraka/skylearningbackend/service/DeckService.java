package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.model.Deck;
import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.repository.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {
    private final DeckRepository deckRepository;
    private final SectionService sectionService;

    public DeckService(DeckRepository deckRepository, SectionService sectionService) {
        this.deckRepository = deckRepository;
        this.sectionService = sectionService;
    }

    public List<Deck> getAllDecks(Long id) {
        return deckRepository.findBySectionId(id);
    }

    public Deck getDeck(Long id, Long deckId) {
        return deckRepository.findBySectionIdAndDeckId(id, deckId);
    }

    public Deck saveDeck(Deck deck, Long id) {
        Section section = sectionService.getSectionById(id);

        if (deck.getName() == null || deck.getDescription() == null) {
            throw new IllegalArgumentException("Deck name and description are required");
        }

        deck.setSection(section);
        Deck savedDeck = deckRepository.save(deck);
        return deckRepository.save(savedDeck);
    }

    public Deck updateDeck(Long id, Long deckId, Deck newDeck) {
        return deckRepository.findById(deckId)
                .map(deck -> {
                    deck.setName(newDeck.getName());
                    deck.setDescription(newDeck.getDescription());
                    return deckRepository.save(deck);
                })
                .orElseGet(() -> deckRepository.save(newDeck));
    }

    public void deleteDeck(Long deckId) {
        deckRepository.deleteById(deckId);
    }

    public int countDecksBySectionId(Long sectionId) {
        return deckRepository.countBySectionId(sectionId);
    }
}
