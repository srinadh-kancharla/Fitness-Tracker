package com.burnboost.fitnesstracker.repository;

import com.burnboost.fitnesstracker.model.User;
import com.burnboost.fitnesstracker.model.WeightRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeightRecordRepository extends JpaRepository<WeightRecord, Long> {
    
    List<WeightRecord> findByUser(User user);
    
    List<WeightRecord> findByUserOrderByRecordDateDesc(User user);
    
    List<WeightRecord> findByUserAndRecordDateBetween(User user, LocalDate startDate, LocalDate endDate);
    
    Optional<WeightRecord> findByUserAndRecordDate(User user, LocalDate date);
    
    @Query("SELECT wr FROM WeightRecord wr WHERE wr.user = ?1 ORDER BY wr.recordDate DESC LIMIT 1")
    Optional<WeightRecord> findLatestByUser(User user);
    
    @Query("SELECT AVG(wr.weight) FROM WeightRecord wr WHERE wr.user = ?1 AND wr.recordDate BETWEEN ?2 AND ?3")
    Double findAverageWeightBetweenDates(User user, LocalDate startDate, LocalDate endDate);
}