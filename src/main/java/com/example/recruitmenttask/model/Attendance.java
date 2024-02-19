package com.example.recruitmenttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "childId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Child child;
    
    LocalDateTime entry_date;
    LocalDateTime exit_date;
}
