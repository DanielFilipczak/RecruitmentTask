package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.School;

import java.util.List;

public interface SchoolService {

    void saveSchool(School school);
    List<School> getAllSchools();
    School getSchoolById(Integer id);
}
