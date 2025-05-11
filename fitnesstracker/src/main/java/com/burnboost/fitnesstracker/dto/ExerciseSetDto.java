package com.burnboost.fitnesstracker.dto;

import lombok.Data;

@Data
public class ExerciseSetDto {
    
    private Long id;
    private Integer setNumber;
    private Integer repetitions;
    private Double weight;
    private Integer duration;
    private Integer distance;
    private Boolean isCompleted;
    private String notes;
}