package com.air.controller;

import com.air.dto.BookingDTO;
import com.air.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable String id) {
        BookingDTO bookingDTO = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDTO);
    }

    // Create a new booking
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO savedBookingDTO = bookingService.createBooking(bookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBookingDTO);
    }

    // Update an existing booking
    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable String id, @RequestBody BookingDTO updatedBookingDTO) {
        BookingDTO savedBookingDTO = bookingService.updateBooking(id, updatedBookingDTO);
        return ResponseEntity.ok(savedBookingDTO);
    }

    // Delete a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    // Get bookings by schedule ID
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByScheduleId(@PathVariable String scheduleId) {
        List<BookingDTO> bookings = bookingService.getBookingsByScheduleId(scheduleId);
        return ResponseEntity.ok(bookings);
    }

    // Delete bookings by schedule ID
    @DeleteMapping("/schedule/{scheduleId}")
    public ResponseEntity<Void> deleteBookingsByScheduleId(@PathVariable String scheduleId) {
        bookingService.deleteBookingsByScheduleId(scheduleId);
        return ResponseEntity.noContent().build();
    }

    // Get bookings by passenger ID
    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByPassengerId(@PathVariable String passengerId) {
        List<BookingDTO> bookings = bookingService.getBookingsByPassengerId(passengerId);
        return ResponseEntity.ok(bookings);
    }

    // Delete bookings by passenger ID
    @DeleteMapping("/passenger/{passengerId}")
    public ResponseEntity<Void> deleteBookingsByPassengerId(@PathVariable String passengerId) {
        bookingService.deleteBookingsByPassengerId(passengerId);
        return ResponseEntity.noContent().build();
    }

    // Get bookings by plane ID
    @GetMapping("/plane/{planeId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByPlaneId(@PathVariable String planeId) {
        List<BookingDTO> bookings = bookingService.getBookingsByPlaneId(planeId);
        return ResponseEntity.ok(bookings);
    }

    // Delete bookings by plane ID
    @DeleteMapping("/plane/{planeId}")
    public ResponseEntity<Void> deleteBookingsByPlaneId(@PathVariable String planeId) {
        bookingService.deleteBookingsByPlaneId(planeId);
        return ResponseEntity.noContent().build();
    }

    // Get bookings by airport ID
    @GetMapping("/airport/{airportId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByAirportId(@PathVariable String airportId) {
        List<BookingDTO> bookings = bookingService.getBookingsByAirportId(airportId);
        return ResponseEntity.ok(bookings);
    }

    // Delete bookings by airport ID
    @DeleteMapping("/airport/{airportId}")
    public ResponseEntity<Void> deleteBookingsByAirportId(@PathVariable String airportId) {
        bookingService.deleteBookingsByAirportId(airportId);
        return ResponseEntity.noContent().build();
    }
}
