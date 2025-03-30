package com.example.weight.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.weight.model.User;
import com.example.weight.model.dto.DailyMealDTO;
import com.example.weight.model.dto.RequestDailyMealDTO;
import com.example.weight.model.dto.UserDTO;
import com.example.weight.service.DailyMealServiceDAO;
import com.example.weight.service.UserServiceDAO;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceDAO userService;
    private final DailyMealServiceDAO dailyMealService;


    @GetMapping("/day-report")
    
    public ResponseEntity<DailyMealDTO> getUserReport(@RequestBody RequestDailyMealDTO dto) {
            DailyMealDTO dailyMealDTO = dailyMealService.generateDailyReport(dto.getUserId(),dto.getDate());
            return ResponseEntity.ok().body(dailyMealDTO);
    }


    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
