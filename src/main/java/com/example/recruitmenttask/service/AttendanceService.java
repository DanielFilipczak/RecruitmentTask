package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Attendance;

import java.util.List;

public interface AttendanceService {

    Attendance saveAttendance(Attendance attendance);
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Integer id);
}
