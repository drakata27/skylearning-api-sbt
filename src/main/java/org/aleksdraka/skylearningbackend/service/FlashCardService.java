package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.model.Deck;
import org.aleksdraka.skylearningbackend.model.FlashCard;
import org.aleksdraka.skylearningbackend.repository.FlashCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final DeckService deckService;

    public FlashCardService(FlashCardRepository flashCardRepository, DeckService deckService) {
        this.flashCardRepository = flashCardRepository;
        this.deckService = deckService;
    }

    public List<FlashCard> getAllFlashCards(Long deckId) {
        return flashCardRepository.findByDeckDeckId(deckId);
    }

    public FlashCard getFlashCard(Long flashCardId) {
        return flashCardRepository.findById(flashCardId).orElse(null);
    }

    public FlashCard updateFlashCard(Long cardId, FlashCard newFlashCard) {
        return flashCardRepository.findById(cardId)
                .map(flashCard -> {
                    flashCard.setQuestion(newFlashCard.getQuestion());
                    flashCard.setAnswer(newFlashCard.getAnswer());
                    return flashCardRepository.save(flashCard);
                })
                .orElseGet(()-> flashCardRepository.save(newFlashCard));
    }

    public FlashCard saveFlashCard(FlashCard flashCard, Long id, Long deckId) {
        Deck deck = deckService.getDeck(id, deckId);

        if (deck.getName() == null || deck.getDescription() == null) {
            throw new IllegalArgumentException("Deck does not have a name/description");
        }

        flashCard.setDeck(deck);
        FlashCard savedCard = flashCardRepository.save(flashCard);
        return flashCardRepository.save(savedCard);
    }

    public void deleteFlashCard(Long flashCardId) {
        flashCardRepository.deleteById(flashCardId);
    }
}
