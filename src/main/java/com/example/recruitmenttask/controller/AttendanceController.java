package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.Attendance;
import com.example.recruitmenttask.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        if (attendance.isValid()) return attendanceService.saveAttendance(attendance);
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
    }

    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Integer id) {
        return attendanceService.getAttendanceById(id);
    }
}
