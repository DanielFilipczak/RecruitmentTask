package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Parent;
import com.example.recruitmenttask.repository.ParentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepo parentRepo;

    public ParentServiceImpl(ParentRepo parentRepo) {
        this.parentRepo = parentRepo;
    }

    @Override
    public Parent saveParent(Parent parent) {
        return parentRepo.save(parent);
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepo.findAll();
    }

    @Override
    public Parent getParentById(Integer id) {
       if(parentRepo.existsById(id)) return parentRepo.findById(id).get();
       else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid id");
    }
}
