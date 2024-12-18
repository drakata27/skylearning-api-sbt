package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.dto.SectionSummaryDTO;
import org.aleksdraka.skylearningbackend.model.Deck;
import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.service.DeckService;
import org.aleksdraka.skylearningbackend.service.FlashCardService;
import org.aleksdraka.skylearningbackend.service.NoteService;
import org.aleksdraka.skylearningbackend.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {
    private final SectionService sectionService;
    private final NoteService noteService;
    private final DeckService deckService;
    private final FlashCardService flashCardService;

    public SectionController(SectionService sectionService, NoteService noteService, DeckService deckService, FlashCardService flashCardService) {
        this.sectionService = sectionService;
        this.noteService = noteService;
        this.deckService = deckService;
        this.flashCardService = flashCardService;
    }

    @GetMapping("/section")
    public List<Section> getSections(@AuthenticationPrincipal OAuth2User principal) {
        return  sectionService.getAllSections(principal);
    }

    @GetMapping("/section/{id}")
    public Section getSection(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }

    @PutMapping("/section/{id}")
    public Section updateSection(@PathVariable Long id,  @RequestBody Section section) {
        return sectionService.updateSection(id, section);
    }

    @PostMapping("/section")
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        try {
            sectionService.saveSection(section);
            return new ResponseEntity<>(section, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/section/{id}")
    public ResponseEntity<Section> deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/section/{id}/summary")
    public SectionSummaryDTO getSectionSummary(@PathVariable Long id) {
        int notesCount = noteService.countNotesBySectionId(id);
        int decksCount = deckService.countDecksBySectionId(id);
        return new SectionSummaryDTO(id, notesCount, decksCount);
    }
}