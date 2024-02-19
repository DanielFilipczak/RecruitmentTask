package com.example.recruitmenttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String firstname;

    @Column(nullable = false)
    String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Parent parent;

    @OneToOne
    @JoinColumn(name = "schoolId")
    School school;
}
