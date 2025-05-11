package com.burnboost.fitnesstracker.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private Double height;
    private List<String> roles;
    private Double currentWeight;
    // Exclude sensitive information like password
}