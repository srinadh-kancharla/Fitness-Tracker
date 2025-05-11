package com.burnboost.fitnesstracker.repository;

import com.burnboost.fitnesstracker.model.FitnessGoal;
import com.burnboost.fitnesstracker.model.FitnessGoal.GoalStatus;
import com.burnboost.fitnesstracker.model.FitnessGoal.GoalType;
import com.burnboost.fitnesstracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FitnessGoalRepository extends JpaRepository<FitnessGoal, Long> {
    
    List<FitnessGoal> findByUser(User user);
    
    List<FitnessGoal> findByUserAndStatus(User user, GoalStatus status);
    
    List<FitnessGoal> findByUserAndGoalType(User user, GoalType goalType);
    
    List<FitnessGoal> findByUserAndTargetDateBefore(User user, LocalDate date);
    
    List<FitnessGoal> findByUserAndStatusAndTargetDateBefore(User user, GoalStatus status, LocalDate date);
    
    List<FitnessGoal> findByUserOrderByTargetDateAsc(User user);
}