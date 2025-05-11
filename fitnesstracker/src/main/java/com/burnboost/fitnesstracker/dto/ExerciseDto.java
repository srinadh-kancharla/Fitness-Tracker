package com.burnboost.fitnesstracker.dto;

import com.burnboost.fitnesstracker.model.Exercise;
import lombok.Data;

import java.util.List;

@Data
public class ExerciseDto {
    
    private Long id;
    private String name;
    private String description;
    private Exercise.ExerciseType exerciseType;
    private Exercise.MuscleGroup primaryMuscleGroup;
    private List<Exercise.MuscleGroup> secondaryMuscleGroups;
    private List<ExerciseSetDto> sets;
}