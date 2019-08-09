package com.services.university.controller;

import com.services.university.model.University;
import com.services.university.service.UniversityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/universities")
    public ResponseEntity postUniversity(@RequestBody University university) {
        log.info("Post a university");
        universityService.save(university);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/universities")
    public ResponseEntity<List<University>> getUniversities() {
        log.info("Get all universities");
        List<University> universities = universityService.getAll();
        return ResponseEntity.ok(universities);
    }

    @DeleteMapping("/universities/{id}")
    public ResponseEntity<List<University>> deleteUniversity(@PathVariable String id) {
        log.info("Delete university, id: {}", id);
        universityService.delete(id);
        return ResponseEntity.ok().build();
    }
}