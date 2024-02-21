package com.example.recruitmenttask.model.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyChildSettlement {
    String firstname;
    String schoolName;
    int totalTime;
    float totalSum;
}
