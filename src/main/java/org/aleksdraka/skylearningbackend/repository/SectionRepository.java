package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
