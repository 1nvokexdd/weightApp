package com.example.weight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weight.model.MealUse;
import com.example.weight.model.User;

public interface MealUseRepository extends JpaRepository<MealUse,Long> {
    List<MealUse>findByUserAndDate(User user , LocalDate date);
}
