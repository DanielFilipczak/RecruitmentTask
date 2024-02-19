package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Child;

import java.util.List;

public interface ChildService {

    void saveChild(Child child);
    List<Child> getAllChildren();
    Child getChildById(Integer id);
}
