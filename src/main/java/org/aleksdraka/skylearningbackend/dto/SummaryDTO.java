package org.aleksdraka.skylearningbackend.dto;

public record SummaryDTO(
        int sectionsCount,
        int decksCount,
        int notesCount
) {
}
