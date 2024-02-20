package com.example.recruitmenttask.model.projection;

import lombok.Data;

@Data
public class MonthlySchoolSettlement {
    String name;
    String month;
    float totalSum;

    public MonthlySchoolSettlement(String name, String month, float totalSum) {
        this.name = name;
        this.month = month;
        this.totalSum = totalSum;
    }
}
