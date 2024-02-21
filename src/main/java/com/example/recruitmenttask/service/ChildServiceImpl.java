package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Child;
import com.example.recruitmenttask.repository.ChildRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepo childRepo;

    public ChildServiceImpl(ChildRepo childRepo) {
        this.childRepo = childRepo;
    }

    @Override
    public Child saveChild(Child child) {
       return childRepo.save(child);
    }

    @Override
    public List<Child> getAllChildren() {
        return childRepo.findAll();
    }

    @Override
    public Child getChildById(Integer id) {
        if (childRepo.existsById(id)) return childRepo.findById(id).get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid id");
    }
}
