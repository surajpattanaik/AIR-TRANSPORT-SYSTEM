package com.air.repository;

import com.air.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    @Query(value = "SELECT b.* FROM Booking b WHERE b.schedule_id = :scheduleId", nativeQuery = true)
    List<Booking> findByScheduleId(String scheduleId);

    @Query(value = "SELECT b.* FROM Booking b WHERE b.passenger_id = :passengerId", nativeQuery = true)
    List<Booking> findByPassengerId(String passengerId);

    @Query(value = "SELECT b.* FROM Booking b INNER JOIN Schedule s ON b.schedule_id = s.id WHERE s.plane_id = :planeId", nativeQuery = true)
    List<Booking> findBySchedule_PlaneId(String planeId);

    @Query(value = "SELECT b.* FROM Booking b INNER JOIN Schedule s ON b.schedule_id = s.id WHERE s.source_airport_id = :airportId OR s.destination_airport_id = :airportId", nativeQuery = true)
    List<Booking> findBySchedule_SourceAirportIdOrSchedule_DestinationAirportId(String airportId);
}
