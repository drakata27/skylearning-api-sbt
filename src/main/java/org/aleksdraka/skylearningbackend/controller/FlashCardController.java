package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.FlashCard;
import org.aleksdraka.skylearningbackend.service.FlashCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlashCardController {
    private final FlashCardService flashCardService;
    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    @GetMapping("/section/{id}/decks/{deckId}/flashcards")
    public List<FlashCard> getFlashCards(@PathVariable Long id, @PathVariable Long deckId) {
        return flashCardService.getAllFlashCards(deckId);
    }

    @GetMapping("/section/{id}/decks/{deckId}/flashcards/{cardId}")
    public FlashCard getFlashCard(@PathVariable Long id, @PathVariable Long deckId, @PathVariable Long cardId) {
        return flashCardService.getFlashCard(cardId);
    }

    @PutMapping("/section/{id}/decks/{deckId}/flashcards/{cardId}")
    public FlashCard updateFlashCard(
            @PathVariable Long id, @PathVariable Long deckId,
            @PathVariable Long cardId, @RequestBody FlashCard flashCard) {
        return flashCardService.updateFlashCard(cardId, flashCard);
    }



    @PostMapping("/section/{id}/decks/{deckId}/flashcards")
    public ResponseEntity<FlashCard> createFlashCard(@RequestBody FlashCard flashCard, @PathVariable Long id, @PathVariable Long deckId) {
        try {
            FlashCard savedFlashCard = flashCardService.saveFlashCard(flashCard,id , deckId);
            return new ResponseEntity<>(savedFlashCard, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/section/{id}/decks/{deckId}/flashcards/{cardId}")
    public ResponseEntity<FlashCard> deleteFlashCard(@PathVariable Long id, @PathVariable Long deckId, @PathVariable Long cardId) {
        flashCardService.deleteFlashCard(cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
