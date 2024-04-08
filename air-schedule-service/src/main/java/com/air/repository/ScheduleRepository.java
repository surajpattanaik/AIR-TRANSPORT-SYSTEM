package com.air.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
	List<Schedule> findBySourceAirportIdOrDestinationAirportId(String sourceAirportId, String destinationAirportId);

	List<Schedule> findByPlaneId(String planeId);
}
