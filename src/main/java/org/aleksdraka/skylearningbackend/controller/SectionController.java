package org.aleksdraka.skylearningbackend.controller;

import org.aleksdraka.skylearningbackend.model.Section;
import org.aleksdraka.skylearningbackend.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
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

    @PutMapping("/section/{id}")
    public Section updateSection(@PathVariable Long id,  @RequestBody Section section) {
        return sectionService.updateSection(id, section);
    }

    @CrossOrigin
    @PostMapping("/section")
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        sectionService.saveSection(section);
        return new ResponseEntity<>(section, HttpStatus.CREATED);
    }

    @DeleteMapping("/section/{id}")
    public ResponseEntity<Section> deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}