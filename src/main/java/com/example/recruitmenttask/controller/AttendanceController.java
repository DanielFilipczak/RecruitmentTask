package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.Attendance;
import com.example.recruitmenttask.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public ResponseEntity<?> addAttendance(@RequestBody Attendance attendance) {
        attendanceService.saveAttendance(attendance);
        return ResponseEntity.created(URI.create("/attendances/" + attendance.getId())).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllAttendances() {
        return ResponseEntity.ok(attendanceService.getAllAttendances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttendanceById(@PathVariable Integer id) {
        return ResponseEntity.ok(attendanceService.getAttendanceById(id));
    }
}
