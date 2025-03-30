package com.example.weight.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.weight.model.MealUse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyMealDTO {
    LocalDate date;
    double dailyCallories;
    double dailyNorm;
    boolean dailyAch;
    List<MealUse> meals;
}
