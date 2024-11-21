package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findBySectionId(Long id);

    Optional<Note> findBySectionIdAndNoteId(Long id, Long noteId);
    void deleteBySectionIdAndNoteId(Long id, Long noteId);
}
