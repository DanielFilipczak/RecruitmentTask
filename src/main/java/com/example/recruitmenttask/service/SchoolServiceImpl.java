package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.School;
import com.example.recruitmenttask.repository.SchoolRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepo schoolRepo;

    public SchoolServiceImpl(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    public void saveSchool(School school) {
        schoolRepo.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    public School getSchoolById(Integer id) {
        return schoolRepo.findById(id).orElse(null);
    }
}
