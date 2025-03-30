package com.example.weight.service;

import java.time.LocalDate;

import com.example.weight.model.dto.DailyMealDTO;

public interface DailyMealServiceDAO {
    DailyMealDTO generateDailyReport(Long userId , LocalDate date);
}
