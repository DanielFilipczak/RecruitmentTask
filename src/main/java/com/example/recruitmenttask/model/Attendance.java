package com.example.recruitmenttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
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

    @Column(nullable = false)
    LocalDateTime entry_date;
    @Column(nullable = false)
    LocalDateTime exit_date;

    @AssertTrue(message = "Invalid exit date")
    public boolean isValid() {
        return entry_date.isBefore(exit_date) || entry_date.isEqual(exit_date);
    }
}
