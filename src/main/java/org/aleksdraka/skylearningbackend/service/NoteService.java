package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.exception.NoteNotFoundException;
import org.aleksdraka.skylearningbackend.model.Note;
import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final SectionService sectionService;

    public NoteService(SectionService sectionService, NoteRepository noteRepository) {
        this.sectionService = sectionService;
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes(Long id) {
        return noteRepository.findBySectionId(id);
    }

    public Note getNote(Long id, Long noteId) {
        return noteRepository.findBySectionIdAndNoteId(id, noteId)
                .orElseThrow(() -> new NoteNotFoundException(id, noteId));
    }

    public Note saveNote(Note note, Long id) {
        Section section = sectionService.getSectionById(id);
        note.setSection(section);
        Note savedNote = noteRepository.save(note);
        return noteRepository.save(savedNote);
    }

    // FIXME
    public Optional<Note> deleteNote(Long id, Long noteId) {
        return noteRepository.deleteBySectionIdAndNoteId(id, noteId);
    }
}
