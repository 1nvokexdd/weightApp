package com.example.weight.model.dto;


import com.example.weight.model.enums.Target;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotBlank
    @Size(min = 2 , max = 25 , message =  "min name length 2 , max name length 25")
    private String name;
    @Email(message = "the line must be according to the pattern user@gmail.com")
    @NotBlank
    private String email;
    @Min(value = 5 , message = "min age 5 years")
    @Max(value = 100 , message =  "max age 100 years")
    @NotNull
    private int age;
    @Min(value = 20 , message = "min weight 20 kg")
    @Max(value = 500 , message =  "max weight 500 kg")
    @NotNull
    private double weight;
    @Min(value = 110 , message = "min height 110 sm")
    @Max(value = 250  , message =  "max height 250 sm")
    @NotNull
    private double height;
    @NotNull(message = "Target cannot be null")
    private Target target;
}
