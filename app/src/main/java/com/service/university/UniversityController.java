package com.service.university;

import com.service.university.model.University;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
@RestController
public class UniversityController {

    @GetMapping("/universities")
    public ResponseEntity<List<University>> getStudents() {
        log.info("Get all students");
      //  List<Student> allStudents = studentService.getAll();
        return ResponseEntity.ok(asList());
    }
}
