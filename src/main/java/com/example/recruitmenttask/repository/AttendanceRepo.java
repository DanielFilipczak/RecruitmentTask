package com.example.recruitmenttask.repository;

import com.example.recruitmenttask.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
    @Query(value = "SELECT a FROM Attendance a WHERE a.child.id IN (:ids)")
    List<List<Attendance>> findAllByChildIds(List<Integer> ids);
}
