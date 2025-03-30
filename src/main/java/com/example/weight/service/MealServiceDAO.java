package com.example.weight.service;

import com.example.weight.model.Meal;
import com.example.weight.model.User;
import com.example.weight.model.dto.MealDTO;
import com.example.weight.model.dto.UserDTO;

public interface MealServiceDAO {
    public Meal save(Meal meal);

    public Meal create(MealDTO dto);
    
}
