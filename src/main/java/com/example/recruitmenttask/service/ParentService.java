package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Parent;

import java.util.List;

public interface ParentService {

    Parent saveParent(Parent parent);
    List<Parent> getAllParents();
    Parent getParentById(Integer id);
}
