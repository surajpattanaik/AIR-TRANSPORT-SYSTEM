package com.air.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.air.dto.BookingDTO;

@FeignClient(name = "booking-service")
public interface BookingFeignClient {

    // Get bookings by schedule ID
    @GetMapping("/api/bookings/schedule/{scheduleId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByScheduleId(@PathVariable String scheduleId);

    // Delete bookings by schedule ID
    @DeleteMapping("/api/bookings/schedule/{scheduleId}")
    public ResponseEntity<Void> deleteBookingsByScheduleId(@PathVariable String scheduleId);

}
