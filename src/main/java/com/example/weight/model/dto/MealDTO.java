package com.example.weight.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MealDTO {
    @Size(min = 2 , max = 100 , message = "min length 2 , max length 100")
    private String name;
    private double calories;
    private double proteins;
    private double fats;
    private double carbs;
}
