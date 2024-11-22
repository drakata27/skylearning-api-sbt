package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.exception.SectionNotFoundException;
import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.repository.SectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    // FIXME
    public Section getSectionById(Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException(id));
    }

    public void saveSection(Section section) {
        sectionRepository.save(section);
    }

    public Section updateSection(@PathVariable Long id, Section newSection) {
        return sectionRepository.findById(id)
                .map(section -> {
                    section.setTitle(newSection.getTitle());
                    section.setSubtitle(newSection.getSubtitle());
                    return sectionRepository.save(section);
                })
                .orElseGet(() -> sectionRepository.save(newSection));
    }

    public void deleteSection(@PathVariable Long id) {
            sectionRepository.deleteById(id);
    }

}