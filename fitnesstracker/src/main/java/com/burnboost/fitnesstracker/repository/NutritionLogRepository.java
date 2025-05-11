package com.burnboost.fitnesstracker.repository;

import com.burnboost.fitnesstracker.model.NutritionLog;
import com.burnboost.fitnesstracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface NutritionLogRepository extends JpaRepository<NutritionLog, Long> {
    
    List<NutritionLog> findByUser(User user);
    
    Optional<NutritionLog> findByUserAndLogDate(User user, LocalDate logDate);
    
    List<NutritionLog> findByUserAndLogDateBetween(User user, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT nl FROM NutritionLog nl WHERE nl.user = ?1 ORDER BY nl.logDate DESC")
    List<NutritionLog> findLatestByUser(User user, org.springframework.data.domain.Pageable pageable);
    
    @Query("SELECT AVG(nl.totalCalories) FROM NutritionLog nl WHERE nl.user = ?1 AND nl.logDate BETWEEN ?2 AND ?3")
    Double findAverageCaloriesBetweenDates(User user, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT AVG(nl.totalProtein) FROM NutritionLog nl WHERE nl.user = ?1 AND nl.logDate BETWEEN ?2 AND ?3")
    Double findAverageProteinBetweenDates(User user, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT AVG(nl.totalCarbs) FROM NutritionLog nl WHERE nl.user = ?1 AND nl.logDate BETWEEN ?2 AND ?3")
    Double findAverageCarbsBetweenDates(User user, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT AVG(nl.totalFat) FROM NutritionLog nl WHERE nl.user = ?1 AND nl.logDate BETWEEN ?2 AND ?3")
    Double findAverageFatBetweenDates(User user, LocalDate startDate, LocalDate endDate);
}