package com.air.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.air.dto.BookingDTO;
import com.air.entity.Booking;

@Component
public class BookingMapper {

    public BookingDTO toDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        BeanUtils.copyProperties(booking, bookingDTO);
        return bookingDTO;
    }

    public Booking toEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingDTO, booking);
        return booking;
    }
}
