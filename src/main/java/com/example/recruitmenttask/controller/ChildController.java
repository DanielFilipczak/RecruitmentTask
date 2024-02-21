package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.Child;
import com.example.recruitmenttask.service.ChildService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children")
public class ChildController {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Child addChild(@RequestBody Child child) {
        return childService.saveChild(child);
    }

    @GetMapping
    public List<Child> getAllChildren() {
        return childService.getAllChildren();
    }

    @GetMapping("/{id}")
    public Child getChildById(@PathVariable Integer id) {
        return childService.getChildById(id);
    }
}
