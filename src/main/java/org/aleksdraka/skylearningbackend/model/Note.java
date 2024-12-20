package org.aleksdraka.skylearningbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noteId", nullable = false, updatable = false)
    private Long noteId;
    private String title;
    private String content;

    @Column(nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonBackReference
    private Section section;
}
