package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Parent;

import java.util.List;

public interface ParentService {

    void saveParent(Parent parent);
    List<Parent> getAllParents();
    Parent getParentById(Integer id);
}
