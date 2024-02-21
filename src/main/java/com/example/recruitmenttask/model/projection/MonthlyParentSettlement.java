package com.example.recruitmenttask.model.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MonthlyParentSettlement {
    String firstname;
    String lastname;
    List<MonthlyChildSettlement> childSettlements;
    float totalSum;
}
