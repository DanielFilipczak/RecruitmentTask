package com.example.recruitmenttask.model.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlySchoolSettlement {
    String name;
    String month;
    float totalSum;
}
