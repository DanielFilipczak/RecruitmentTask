package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Parent;
import com.example.recruitmenttask.repository.ParentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepo parentRepo;

    public ParentServiceImpl(ParentRepo parentRepo) {
        this.parentRepo = parentRepo;
    }

    @Override
    public void saveParent(Parent parent) {
        parentRepo.save(parent);
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepo.findAll();
    }

    @Override
    public Parent getParentById(Integer id) {
        return parentRepo.findById(id).orElse(null);
    }
}
