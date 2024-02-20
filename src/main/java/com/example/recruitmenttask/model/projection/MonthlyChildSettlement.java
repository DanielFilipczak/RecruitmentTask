package com.example.recruitmenttask.model.projection;

import lombok.Data;

@Data
public class MonthlyChildSettlement {
    String firstname;
    String schoolName;
    int totalTime;
    float totalSum;

    public MonthlyChildSettlement(String firstname, String schoolName, int totalTime, float totalSum) {
        this.firstname = firstname;
        this.schoolName = schoolName;
        this.totalTime = totalTime;
        this.totalSum = totalSum;
    }
}
