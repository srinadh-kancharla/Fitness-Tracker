package com.burnboost.fitnesstracker.repository;

import com.burnboost.fitnesstracker.model.Role;
import com.burnboost.fitnesstracker.model.Role.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Optional<Role> findByName(ERole name);
}