package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.Parent;
import com.example.recruitmenttask.service.ParentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/parents")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping
    public ResponseEntity<?> addParent(@RequestBody Parent parent) {
        parentService.saveParent(parent);
        return ResponseEntity.created(URI.create("/parents/" + parent.getId())).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllParents() {
        return ResponseEntity.ok(parentService.getAllParents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getParentById(@PathVariable Integer id) {
        return ResponseEntity.ok(parentService.getParentById(id));
    }
}
