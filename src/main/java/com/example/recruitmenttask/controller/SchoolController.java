package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.School;
import com.example.recruitmenttask.model.projection.MonthlyParentSettlement;
import com.example.recruitmenttask.model.projection.MonthlySchoolSettlement;
import com.example.recruitmenttask.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public School addSchool(@RequestBody School school) {
        return schoolService.saveSchool(school);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Integer id) {
        return schoolService.getSchoolById(id);
    }

    @GetMapping("/settlements/{id}")
    public MonthlySchoolSettlement getMonthlySchoolSettlement(@PathVariable Integer id, @RequestParam int month) {
        return schoolService.getSchoolSettlementByMonth(id, month);
    }

    @GetMapping("/settlements/{id}/{parentId}")
    public MonthlyParentSettlement getMonthlyParentSettlement(@PathVariable Integer id, @RequestParam int month, @PathVariable Integer parentId) {
        return schoolService.getParentSettlementByMonth(id, month, parentId);
    }
}
