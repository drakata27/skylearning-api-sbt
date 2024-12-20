package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.dto.SummaryDTO;
import org.aleksdraka.skylearningbackend.service.DeckService;
import org.aleksdraka.skylearningbackend.service.NoteService;
import org.aleksdraka.skylearningbackend.service.SectionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController {
    private final SectionService sectionService;
    private final NoteService noteService;
    private final DeckService deckService;

    public SummaryController(SectionService sectionService, NoteService noteService, DeckService deckService) {
        this.sectionService = sectionService;
        this.noteService = noteService;
        this.deckService = deckService;
    }

    @GetMapping("/summary")
    public SummaryDTO summary(@AuthenticationPrincipal OAuth2User principal) {
        int sectionsCount = sectionService.getAllSectionsSummary(principal);
        int notesCount = noteService.getAllNotesSummary(principal);
        int decksCount = deckService.getAllDecksSummary(principal);

        return new SummaryDTO(sectionsCount,  decksCount, notesCount);
    }
}
