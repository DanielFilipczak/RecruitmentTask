package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Attendance;
import com.example.recruitmenttask.repository.AttendanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepo attendanceRepo;

    public AttendanceServiceImpl(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    @Override
    public void saveAttendance(Attendance attendance) {
        if (attendance.isValid())
            attendanceRepo.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepo.findAll();
    }

    @Override
    public Attendance getAttendanceById(Integer id) {
        return attendanceRepo.findById(id).orElse(null);
    }
}
