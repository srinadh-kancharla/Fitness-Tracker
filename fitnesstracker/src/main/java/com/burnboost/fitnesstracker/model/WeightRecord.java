package com.burnboost.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "weight_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    private Double weight; // in kg
    
    private LocalDate recordDate;
    
    private Double bodyFatPercentage;
    
    private String notes;
}