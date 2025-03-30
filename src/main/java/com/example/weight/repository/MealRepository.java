package com.example.weight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weight.model.Meal;

public interface  MealRepository  extends JpaRepository<Meal,Long>{
    boolean existsByName(String name);
}
