package com.services.university.repository;

import com.services.university.model.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends CrudRepository<University, String> {
    public List<University> findAll();
}