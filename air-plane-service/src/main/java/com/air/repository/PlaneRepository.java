package com.air.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.entity.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {
    
}

