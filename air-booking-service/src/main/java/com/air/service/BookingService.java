package com.air.service;

import com.air.dto.BookingDTO;
import com.air.entity.Booking;
import com.air.exception.bean.ResourceNotFoundException;
import com.air.proxy.IdGeneratorFeignClient;
import com.air.repository.BookingRepository;
import com.air.utils.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private IdGeneratorFeignClient idGenerator;

    @Autowired
    private BookingMapper bookingMapper;

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookingDTO getBookingById(String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        return bookingMapper.toDTO(booking);
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        booking.setId(idGenerator.getGeneratedId());
        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(savedBooking);
    }

    public BookingDTO updateBooking(String id, BookingDTO updatedBookingDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        booking.setScheduleId(updatedBookingDTO.getScheduleId());
        booking.setPassengerId(updatedBookingDTO.getPassengerId());
        booking.setSeatNumber(updatedBookingDTO.getSeatNumber());
        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(savedBooking);
    }

    public void deleteBooking(String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        bookingRepository.delete(booking);
    }

    public List<BookingDTO> getBookingsByScheduleId(String scheduleId) {
        return bookingRepository.findByScheduleId(scheduleId)
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteBookingsByScheduleId(String scheduleId) {
        List<Booking> bookings = bookingRepository.findByScheduleId(scheduleId);
        bookingRepository.deleteAll(bookings);
    }

    public List<BookingDTO> getBookingsByPassengerId(String passengerId) {
        return bookingRepository.findByPassengerId(passengerId)
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteBookingsByPassengerId(String passengerId) {
        List<Booking> bookings = bookingRepository.findByPassengerId(passengerId);
        bookingRepository.deleteAll(bookings);
    }
    public List<BookingDTO> getBookingsByPlaneId(String planeId) {
        return bookingRepository.findBySchedule_PlaneId(planeId)
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteBookingsByPlaneId(String planeId) {
        List<Booking> bookings = bookingRepository.findBySchedule_PlaneId(planeId);
        bookingRepository.deleteAll(bookings);
    }

    public List<BookingDTO> getBookingsByAirportId(String airportId) {
        return bookingRepository.findBySchedule_SourceAirportIdOrSchedule_DestinationAirportId(airportId)
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteBookingsByAirportId(String airportId) {
        List<Booking> bookings = bookingRepository.findBySchedule_SourceAirportIdOrSchedule_DestinationAirportId(airportId);
        bookingRepository.deleteAll(bookings);
    }
}
