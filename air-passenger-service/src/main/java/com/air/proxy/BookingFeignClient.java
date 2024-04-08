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

    // Get bookings by passenger ID
    @GetMapping("/api/bookings/passenger/{passengerId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByPassengerId(@PathVariable String passengerId);

    // Delete bookings by passenger ID
    @DeleteMapping("/api/bookings/passenger/{passengerId}")
    public ResponseEntity<Void> deleteBookingsByPassengerId(@PathVariable String passengerId);

}
