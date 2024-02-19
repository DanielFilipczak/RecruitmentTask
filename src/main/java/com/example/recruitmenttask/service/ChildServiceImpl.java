package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Child;
import com.example.recruitmenttask.repository.ChildRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepo childRepo;

    public ChildServiceImpl(ChildRepo childRepo) {
        this.childRepo = childRepo;
    }

    @Override
    public void saveChild(Child child) {
        childRepo.save(child);
    }

    @Override
    public List<Child> getAllChildren() {
        return childRepo.findAll();
    }

    @Override
    public Child getChildById(Integer id) {
        return childRepo.findById(id).orElse(null);
    }
}
