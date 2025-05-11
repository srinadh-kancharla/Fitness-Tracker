package com.burnboost.fitnesstracker.dto;

import com.burnboost.fitnesstracker.model.Workout;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkoutDto {
    
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer caloriesBurned;
    private Workout.WorkoutType workoutType;
    private List<ExerciseDto> exercises;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}