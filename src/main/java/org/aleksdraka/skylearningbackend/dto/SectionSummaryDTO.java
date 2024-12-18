package org.aleksdraka.skylearningbackend.dto;

public record SectionSummaryDTO(
        Long sectionId,
        int notesCount,
        int decksCount
) {
}
