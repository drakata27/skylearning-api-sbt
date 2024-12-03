package org.aleksdraka.skylearningbackend.service;

import org.aleksdraka.skylearningbackend.exception.SectionNotFoundException;
import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.repository.SectionRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<Section> getAllSections(@AuthenticationPrincipal OAuth2User principal) {
//        return sectionRepository.findAll();
        String userId = principal.getName();
        return sectionRepository.findByUserId(userId);
    }

    public Section getSectionById(Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException(id));
    }

    public void saveSection(Section section) {
        if (section.getTitle() == null|| section.getSubtitle() == null) {
            throw new IllegalArgumentException("Section title and subtitle cannot be empty");
        }
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