package org.aleksdraka.skylearningbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String subtitle;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "section", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Note> notes;

    public Section(String title, String subtitle, User owner) {
        this.title = title;
        this.subtitle = subtitle;
        this.owner = owner;
    }
}
