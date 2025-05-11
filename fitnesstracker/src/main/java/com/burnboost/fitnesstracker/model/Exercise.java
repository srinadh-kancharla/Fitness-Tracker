package com.burnboost.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;
    
    private String name;
    
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private ExerciseType exerciseType;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private MuscleGroup primaryMuscleGroup;
    
    @ElementCollection
    @CollectionTable(name = "exercise_secondary_muscles", 
        joinColumns = @JoinColumn(name = "exercise_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "muscle_group")
    private List<MuscleGroup> secondaryMuscleGroups = new ArrayList<>();
    
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseSet> sets = new ArrayList<>();
    
    public enum ExerciseType {
        STRENGTH,
        CARDIO,
        FLEXIBILITY,
        BODYWEIGHT,
        MACHINE,
        FREE_WEIGHTS,
        CALISTHENICS,
        OTHER
    }
    
    public enum MuscleGroup {
        CHEST,
        BACK,
        SHOULDERS,
        BICEPS,
        TRICEPS,
        FOREARMS,
        QUADRICEPS,
        HAMSTRINGS,
        CALVES,
        GLUTES,
        ABS,
        CORE,
        FULL_BODY,
        NONE
    }
}