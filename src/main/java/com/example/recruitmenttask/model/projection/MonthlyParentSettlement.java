package com.example.recruitmenttask.model.projection;

import lombok.Data;

import java.util.List;

@Data
public class MonthlyParentSettlement {
    String firstname;
    String lastname;
    List<MonthlyChildSettlement> childSettlements;
    float totalSum;

    public MonthlyParentSettlement(String firstname, String lastname, List<MonthlyChildSettlement> childSettlements, float totalSum) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.childSettlements = childSettlements;
        this.totalSum = totalSum;
    }
}
