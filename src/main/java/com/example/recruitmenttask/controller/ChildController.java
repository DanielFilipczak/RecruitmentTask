package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.Child;
import com.example.recruitmenttask.service.ChildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/children")
public class ChildController {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @PostMapping
    public ResponseEntity<?> addChild(@RequestBody Child child) {
        childService.saveChild(child);
        return ResponseEntity.created(URI.create("/children/" + child.getId())).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllChildren() {
        return ResponseEntity.ok(childService.getAllChildren());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getChildById(@PathVariable Integer id) {
        return ResponseEntity.ok(childService.getChildById(id));
    }
}
