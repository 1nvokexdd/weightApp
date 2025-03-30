package com.example.weight.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.weight.model.User;
import com.example.weight.model.dto.DailyMealDTO;
import com.example.weight.model.dto.RequestDailyMealDTO;
import com.example.weight.model.dto.UserDTO;
import com.example.weight.service.DailyMealServiceDAO;
import com.example.weight.service.UserServiceDAO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name= "user controller" , description = "controller for add user , add get day report")
public class UserController {
    private final UserServiceDAO userService;
    private final DailyMealServiceDAO dailyMealService;


    @GetMapping("/day-report")
    @Operation(summary = "Get daily report  " ,description = "getting daily report for user")
    @ApiResponse(responseCode = "200", description = " getting user report")
    public ResponseEntity<DailyMealDTO> getUserReport(@RequestBody RequestDailyMealDTO dto) {
            DailyMealDTO dailyMealDTO = dailyMealService.generateDailyReport(dto.getUserId(),dto.getDate());
            return ResponseEntity.ok().body(dailyMealDTO);
    }


    @PostMapping("/add-user")
    @Operation(summary = "Add user" ,description = "create user")
    @ApiResponse(responseCode = "201", description = " user created")
    @ApiResponse(responseCode = "400", description = "error , user not created")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
