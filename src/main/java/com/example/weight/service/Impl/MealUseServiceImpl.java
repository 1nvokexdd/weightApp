package com.example.weight.service.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.weight.model.Meal;
import com.example.weight.model.MealUse;
import com.example.weight.model.User;
import com.example.weight.model.dto.MealUserDTO;
import com.example.weight.repository.MealRepository;
import com.example.weight.repository.MealUseRepository;
import com.example.weight.repository.UserRepository;
import com.example.weight.service.MealUseServiceDAO;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MealUseServiceImpl implements MealUseServiceDAO {
    private final MealUseRepository mealUseRepository;
    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    @Override
    public MealUse save(MealUse mealUse){
    return mealUseRepository.save(mealUse);
    }
    @Override
    public MealUse createMealUse(MealUserDTO mealUseDto) {
        User user = userRepository.findById(mealUseDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + mealUseDto.getUserId()));

        List<Meal> meals = mealRepository.findAllById(mealUseDto.getMealIds());
        if (meals.isEmpty()) {
            throw new EntityNotFoundException("No meals found with provided ids");
        }

        MealUse mealUse = MealUse.builder()
                .user(user)
                .date(mealUseDto.getDate() != null ? mealUseDto.getDate() : LocalDate.now())
                .meals(meals)
                .build();

        return save(mealUse);
    }

    
}
