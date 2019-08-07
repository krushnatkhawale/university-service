package com.service.university.controller;

import com.service.university.model.University;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
@RestController
public class UniversityController {

    @PostMapping("/universities")
    public ResponseEntity postUniversity(@RequestBody University university) {
        log.info("Post a university");
        //  List<Student> allStudents = studentService.getAll();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/universities")
    public ResponseEntity<List<University>> getUniversities() {
        log.info("Get all universities");
        //  List<Student> allStudents = studentService.getAll();
        return ResponseEntity.ok(asList());
    }
}