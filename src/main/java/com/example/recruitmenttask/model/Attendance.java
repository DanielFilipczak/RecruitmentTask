package com.example.recruitmenttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "childId", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Child child;

    @Column(name = "entry_date", nullable = false)
    LocalDateTime entryDate;
    @Column(name = "exit_date", nullable = false)
    LocalDateTime exitDate;

    @AssertTrue
    public boolean isValid() {
        return entryDate.isBefore(exitDate) || entryDate.isEqual(exitDate);
    }
}
