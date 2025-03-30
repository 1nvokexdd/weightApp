package com.example.weight.service.Impl;

import org.springframework.stereotype.Service;

import com.example.weight.model.Meal;
import com.example.weight.model.dto.MealDTO;
import com.example.weight.repository.MealRepository;
import com.example.weight.service.MealServiceDAO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MealServiceImpl implements MealServiceDAO{
    private final MealRepository repository;
     public Meal save(Meal meal){
    return repository.save(meal);
    };

    public Meal create(MealDTO dto){
    if (repository.existsByName(dto.getName())) {
        throw new RuntimeException("This meal already exist");
    }
    Meal meal  = Meal.builder()
    .name(dto.getName())
    .calories(dto.getCalories())
    .proteins(dto.getProteins())
    .fats(dto.getFats())
    .carbs(dto.getCarbs())
    .build();
    
    
    return save(meal);
    };
    
}
