package com.example.weight.service;

import com.example.weight.model.MealUse;
import com.example.weight.model.dto.MealUserDTO;

public interface MealUseServiceDAO {
    MealUse save(MealUse mealUse);
    MealUse createMealUse(MealUserDTO mealUseDto);
}
