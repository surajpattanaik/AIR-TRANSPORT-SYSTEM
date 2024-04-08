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

    // Get bookings by plane ID
    @GetMapping("/api/bookings/plane/{planeId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByPlaneId(@PathVariable String planeId);

    // Delete bookings by plane ID
    @DeleteMapping("/api/bookings/plane/{planeId}")
    public ResponseEntity<Void> deleteBookingsByPlaneId(@PathVariable String planeId);

}
