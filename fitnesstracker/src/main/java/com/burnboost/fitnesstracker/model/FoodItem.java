package com.burnboost.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;
    
    private String name;
    
    private Double servingSize;
    
    private String servingUnit;
    
    private Integer calories;
    
    private Integer protein; // in grams
    
    private Integer carbs; // in grams
    
    private Integer fat; // in grams
    
    private Integer fiber; // in grams
    
    private Integer sugar; // in grams
    
    private Integer sodium; // in milligrams
    
    private Boolean isCustom; // indicates if this is a custom food or from a database
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_database_item_id")
    private FoodDatabaseItem foodDatabaseItem; // reference to food database if not custom
}