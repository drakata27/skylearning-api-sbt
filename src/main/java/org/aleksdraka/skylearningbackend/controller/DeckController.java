package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.Deck;
import org.aleksdraka.skylearningbackend.service.DeckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
