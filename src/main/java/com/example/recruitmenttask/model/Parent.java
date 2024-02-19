package com.example.recruitmenttask.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String firstname;

    @Column(nullable = false)
    String lastname;
}
