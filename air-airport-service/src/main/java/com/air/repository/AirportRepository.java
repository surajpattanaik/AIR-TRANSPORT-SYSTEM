package com.air.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    
}

