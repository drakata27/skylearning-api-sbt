package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.service.SectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {
    private final SectionService sectionService;
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }
    @GetMapping("/section")
    public List<Section> getSections() {
        return  sectionService.getAllSections();
    }

    @GetMapping("/section/{id}")
    public Section getSection(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }

    @PostMapping("/section")
    public Section createSection(@RequestBody Section section) {
        return sectionService.saveSection(section);
    }

    @PutMapping("/section/{id}")
    public Section updateSection(@PathVariable Long id,  @RequestBody Section section) {
        return sectionService.updateSection(id, section);
    }

    @DeleteMapping("/section/{id}")
    public void deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
    }
}
