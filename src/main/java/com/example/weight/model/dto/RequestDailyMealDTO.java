package com.example.weight.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RequestDailyMealDTO {
    Long userId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    LocalDate date;
}
