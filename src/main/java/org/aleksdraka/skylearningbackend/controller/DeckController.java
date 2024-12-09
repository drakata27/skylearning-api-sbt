package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.Deck;
import org.aleksdraka.skylearningbackend.service.DeckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeckController {
    private final DeckService deckService;
    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/section/{id}/decks")
    public List<Deck> getDecks(@PathVariable("id") Long id) {
        return deckService.getAllDecks(id);
    }

    @GetMapping("/section/{id}/decks/{deckId}")
    public Deck getDeck(@PathVariable("id") Long id, @PathVariable("deckId") Long deckId) {
        return deckService.getDeck(id, deckId);
    }

    @PostMapping("/section/{id}/decks")
    public ResponseEntity<Deck> createDeck(@RequestBody Deck deck, @PathVariable("id") Long id) {
        try {
            Deck savedDeck = deckService.saveDeck(deck, id);
            return new ResponseEntity<>(savedDeck, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/section/{id}/decks/{deckId}")
    public Deck updateDeck(@PathVariable Long id, @PathVariable Long deckId, @RequestBody Deck deck) {
        return deckService.updateDeck(id, deckId, deck);
    }

    @DeleteMapping("/section/{id}/decks/{deckId}")
    public ResponseEntity<Deck> deleteDeck(@PathVariable Long id, @PathVariable Long deckId) {
        deckService.deleteDeck(deckId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
