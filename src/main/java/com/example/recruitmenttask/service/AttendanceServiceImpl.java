package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Attendance;
import com.example.recruitmenttask.repository.AttendanceRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepo attendanceRepo;

    public AttendanceServiceImpl(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepo.findAll();
    }

    @Override
    public Attendance getAttendanceById(Integer id) {
        if (attendanceRepo.existsById(id)) return attendanceRepo.findById(id).get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid id");
    }
}
