package com.burnboost.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise_sets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseSet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;
    
    private Integer setNumber;
    
    private Integer repetitions;
    
    private Double weight; // in kg
    
    private Integer duration; // in seconds, for timed exercises
    
    private Integer distance; // in meters, for distance exercises
    
    private Boolean isCompleted;
    
    private String notes;
}