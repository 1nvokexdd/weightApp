package com.example.weight.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.weight.model.Meal;
import com.example.weight.model.MealUse;
import com.example.weight.model.dto.DailyMealDTO;
import com.example.weight.model.dto.MealDTO;
import com.example.weight.model.dto.MealUserDTO;
import com.example.weight.service.DailyMealServiceDAO;
import com.example.weight.service.MealServiceDAO;
import com.example.weight.service.MealUseServiceDAO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@Tag(name = "meal-controller" , description = "controller for add daily meal and for add meal")
public class MealController {
    private final MealUseServiceDAO mealUseService;
    private final MealServiceDAO mealService;


    @PostMapping("/add-daily-meal")
    @Operation(summary = "Add daily meal " ,description = "add daily meal")
    @ApiResponse(responseCode = "201", description = "daily meal created")
    @ApiResponse(responseCode = "400",description = "daily meal not created ")
    public ResponseEntity<?> addDailyMeal(@Valid@RequestBody MealUserDTO dto) {
        
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(mealUseService.createMealUse(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

    @PostMapping("/add-meal")
    @Operation(summary = "Add  meal " ,description = "add  meal")
    @ApiResponse(responseCode = "201", description = " meal created")
    @ApiResponse(responseCode = "400",description = " meal not created ")
    public ResponseEntity<?> addMeal(@Valid@RequestBody MealDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(mealService.create(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
