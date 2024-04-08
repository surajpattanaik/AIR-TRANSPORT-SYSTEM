package com.air.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.air.dto.BookingDTO;
import com.air.dto.ScheduleDTO;

@FeignClient(name = "booking-service")
public interface BookingFeignClient {

    // Get bookings by airport ID
    @GetMapping("/api/bookings/airport/{airportId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByAirportId(@PathVariable String airportId);

    // Delete bookings by airport ID
    @DeleteMapping("/api/bookings/airport/{airportId}")
    public ResponseEntity<Void> deleteBookingsByAirportId(@PathVariable String airportId);

}
