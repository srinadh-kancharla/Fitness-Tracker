package com.burnboost.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fitness_goals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FitnessGoal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    private String title;
    
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private GoalType goalType;
    
    private Double targetValue; // e.g., target weight, target exercise weight, etc.
    
    private String targetUnit; // e.g., kg, miles, etc.
    
    private LocalDate startDate;
    
    private LocalDate targetDate;
    
    private LocalDate completionDate;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private GoalStatus status;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    public enum GoalType {
        WEIGHT_LOSS,
        MUSCLE_GAIN,
        STRENGTH,
        ENDURANCE,
        FLEXIBILITY,
        NUTRITION,
        GENERAL_FITNESS,
        OTHER
    }
    
    public enum GoalStatus {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED,
        ABANDONED
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }