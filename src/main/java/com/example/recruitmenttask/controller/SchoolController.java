package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.School;
import com.example.recruitmenttask.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<?> addSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
        return ResponseEntity.created(URI.create("/schools/" + school.getId())).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable Integer id) {
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }

    @GetMapping("/settlements/{id}/{month}")
    public ResponseEntity<?> getMonthlySchoolSettlement(@PathVariable Integer id, @PathVariable int month) {
        return ResponseEntity.ok(schoolService.getSchoolSettlementByMonth(id, month));
    }

    @GetMapping("/settlements/{id}/{month}/{parentId}")
    public ResponseEntity<?> getMonthlyParentSettlement(@PathVariable Integer id, @PathVariable int month, @PathVariable Integer parentId) {
        return ResponseEntity.ok(schoolService.getParentSettlementByMonth(id, month, parentId));
    }
}
