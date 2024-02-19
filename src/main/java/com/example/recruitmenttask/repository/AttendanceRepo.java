package com.example.recruitmenttask.repository;

import com.example.recruitmenttask.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
}
