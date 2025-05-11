package com.burnboost.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "food_database")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDatabaseItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String brand;
    
    private Double servingSize;
    
    private String servingUnit;
    
    private Integer calories;
    
    private Integer protein; // in grams
    
    private Integer carbs; // in grams
    
    private Integer fat; // in grams
    
    private Integer fiber; // in grams
    
    private Integer sugar; // in grams
    
    private Integer sodium; // in milligrams
    
    private String barcode;
    
    private Boolean verified;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}