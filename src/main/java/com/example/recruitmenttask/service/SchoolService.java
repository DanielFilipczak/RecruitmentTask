package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.School;
import com.example.recruitmenttask.model.projection.MonthlyParentSettlement;
import com.example.recruitmenttask.model.projection.MonthlySchoolSettlement;

import java.util.List;

public interface SchoolService {

    School saveSchool(School school);
    List<School> getAllSchools();
    School getSchoolById(Integer id);
    MonthlySchoolSettlement getSchoolSettlementByMonth(Integer id, int month);
    MonthlyParentSettlement getParentSettlementByMonth(Integer id, int month, Integer parentId);
}
