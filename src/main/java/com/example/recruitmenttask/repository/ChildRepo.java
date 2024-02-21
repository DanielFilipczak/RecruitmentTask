package com.example.recruitmenttask.repository;

import com.example.recruitmenttask.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepo extends JpaRepository<Child, Integer> {
    @Query(value = "SELECT c.id FROM Child c WHERE c.school.id = :id")
    List<Integer> findIdsBySchoolId(Integer id);
    @Query(value = "SELECT c FROM Child c WHERE c.parent.id = :id")
    List<Child> findAllByParentId(Integer id);
}
