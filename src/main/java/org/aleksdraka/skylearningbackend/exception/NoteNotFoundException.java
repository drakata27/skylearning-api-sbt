package org.aleksdraka.skylearningbackend.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long sectionId, Long noteId) {
        super("Could not find note with id " + noteId + " in section " + sectionId);
    }
}
