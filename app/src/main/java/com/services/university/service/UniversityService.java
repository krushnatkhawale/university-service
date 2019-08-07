package com.services.university.service;

import com.services.university.model.University;
import com.services.university.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversityService {

    private UniversityRepository universityRepository;

    public UniversityService(@Autowired UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public University save(University university) {
        String id = UUID.randomUUID().toString();
        university.setId(id);
        return universityRepository.save(university);
    }

    public University get(String id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No student record found with id " + id));
    }

    public List<University> getAll() {
        return universityRepository.findAll();
    }

    public void delete(String id) {
        universityRepository.deleteById(id);
    }
}