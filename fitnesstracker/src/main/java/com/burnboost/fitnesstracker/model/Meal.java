package com.burnboost.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nutrition_log_id", nullable = false)
    private NutritionLog nutritionLog;
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MealType mealType;
    
    private LocalDateTime mealTime;
    
    private Integer calories;
    
    private Integer protein; // in grams
    
    private Integer carbs; // in grams
    
    private Integer fat; // in grams
    
    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> foodItems = new ArrayList<>();
    
    public enum MealType {
        BREAKFAST,
        LUNCH,
        DINNER,
        SNACK,
        PRE_WORKOUT,
        POST_WORKOUT,
        OTHER
    }
}