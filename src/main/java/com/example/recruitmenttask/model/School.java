package com.example.recruitmenttask.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false, precision = 2)
    float hour_price;
}
