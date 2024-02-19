package com.example.recruitmenttask.repository;

import com.example.recruitmenttask.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepo extends JpaRepository<Child, Integer> {
}
