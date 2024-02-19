package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Attendance;

import java.util.List;

public interface AttendanceService {

    void saveAttendance(Attendance attendance);
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Integer id);
}
