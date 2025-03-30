package com.example.weight.service.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.weight.model.Meal;
import com.example.weight.model.MealUse;
import com.example.weight.model.User;
import com.example.weight.model.dto.DailyMealDTO;
import com.example.weight.repository.MealUseRepository;
import com.example.weight.repository.UserRepository;
import com.example.weight.service.DailyMealServiceDAO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DailyMealServiceImpl implements DailyMealServiceDAO{
    private final UserRepository userRepository;
    private final MealUseRepository mealUseRepository;


    @Override
    public DailyMealDTO generateDailyReport(Long userId , LocalDate date){
    User user = userRepository.findById(userId).orElseThrow(() ->  new RuntimeException("User not found"));
    if (date == null) {
        date = LocalDate.now();
    }
    List<MealUse> uses = mealUseRepository.findByUserAndDate(user, date);

   
    double calSum  = uses.stream()
    .flatMap(use -> use.getMeals().stream())
    .mapToDouble(Meal::getCalories)
    .sum();

    return new DailyMealDTO(
    date,
    calSum,
    user.getCalorie_norm(),
    calSum <= user.getCalorie_norm(),
    uses
    );
    };
    
}