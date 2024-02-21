package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.Parent;
import com.example.recruitmenttask.service.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Parent addParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping("/{id}")
    public Parent getParentById(@PathVariable Integer id) {
        return parentService.getParentById(id);
    }
}
