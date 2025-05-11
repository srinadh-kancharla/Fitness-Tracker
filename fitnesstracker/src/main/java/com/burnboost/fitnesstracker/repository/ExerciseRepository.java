package com.burnboost.fitnesstracker.repository;

import com.burnboost.fitnesstracker.model.Exercise;
import com.burnboost.fitnesstracker.model.Exercise.ExerciseType;
import com.burnboost.fitnesstracker.model.Exercise.MuscleGroup;
import com.burnboost.fitnesstracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    
    List<Exercise> findByWorkout(Workout workout);
    
    List<Exercise> findByExerciseType(ExerciseType exerciseType);
    
    List<Exercise> findByPrimaryMuscleGroup(MuscleGroup muscleGroup);
    
    @Query("SELECT e FROM Exercise e JOIN e.workout w WHERE w.user.id = ?1 AND e.name LIKE %?2%")
    List<Exercise> findByUserIdAndNameContaining(Long userId, String name);
    
    @Query("SELECT e FROM Exercise e JOIN e.workout w WHERE w.user.id = ?1 AND e.primaryMuscleGroup = ?2")
    List<Exercise> findByUserIdAndPrimaryMuscleGroup(Long userId, MuscleGroup muscleGroup);
}