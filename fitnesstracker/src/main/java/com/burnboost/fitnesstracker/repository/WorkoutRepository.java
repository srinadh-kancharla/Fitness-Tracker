package com.burnboost.fitnesstracker.repository;

import com.burnboost.fitnesstracker.model.User;
import com.burnboost.fitnesstracker.model.Workout;
import com.burnboost.fitnesstracker.model.Workout.WorkoutType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    
    List<Workout> findByUser(User user);
    
    Page<Workout> findByUser(User user, Pageable pageable);
    
    List<Workout> findByUserAndWorkoutType(User user, WorkoutType workoutType);
    
    List<Workout> findByUserAndStartTimeBetween(User user, LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT w FROM Workout w WHERE w.user = ?1 ORDER BY w.startTime DESC")
    List<Workout> findUserRecentWorkouts(User user, Pageable pageable);
    
    @Query("SELECT COUNT(w) FROM Workout w WHERE w.user = ?1 AND w.startTime >= ?2")
    Long countWorkoutsSince(User user, LocalDateTime since);
}