package org.aleksdraka.skylearningbackend.repository;

import org.aleksdraka.skylearningbackend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findByUserId(String userId);
    int countByUserId(String userId);
}
