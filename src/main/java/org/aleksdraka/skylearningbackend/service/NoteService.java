package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.exception.NoteNotFoundException;
import org.aleksdraka.skylearningbackend.model.Note;
import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Note updateNote(Long id, Long noteId, Note newNote) {
        return noteRepository.findById(noteId)
                .map(note -> {
                    note.setTitle(newNote.getTitle());
                    note.setContent(newNote.getContent());
                    return noteRepository.save(note);
                })
                .orElseGet(()-> noteRepository.save(newNote));
    }

    public Note saveNote(Note note, Long id) {
        Section section = sectionService.getSectionById(id);
        note.setSection(section);
        Note savedNote = noteRepository.save(note);
        return noteRepository.save(savedNote);
    }

    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}
