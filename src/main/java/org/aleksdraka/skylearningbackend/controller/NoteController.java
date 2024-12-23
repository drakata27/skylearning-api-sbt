package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.Note;
import org.aleksdraka.skylearningbackend.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    private final NoteService noteService;
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/section/{id}/note")
    public List<Note> getNotes(@PathVariable("id") Long id) {
        return noteService.getAllNotes(id);
    }

    @GetMapping("/section/{id}/note/{noteId}")
    public Note getNote(@PathVariable("id") Long id, @PathVariable("noteId") Long noteId) {
        return noteService.getNote(id, noteId);
    }

    @PutMapping("/section/{id}/note/{noteId}")
    public Note updateNote(@PathVariable Long id, @PathVariable Long noteId, @RequestBody Note note) {
        return noteService.updateNote(id, noteId, note);
    }

    @PostMapping("/section/{id}/note")
    public ResponseEntity<Note> createNote(@RequestBody Note note, @PathVariable Long id) {
        try {
            Note savedNote = noteService.saveNote(note, id);
            return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/section/{id}/note/{noteId}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id, @PathVariable Long noteId) {
        noteService.deleteNote(noteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
