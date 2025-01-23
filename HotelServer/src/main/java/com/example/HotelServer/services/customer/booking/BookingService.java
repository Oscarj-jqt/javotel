package com.example.HotelServer.services.customer.booking;

import com.example.HotelServer.dto.ReservationDto;
import com.example.HotelServer.dto.ReservationResponseDto;


public interface BookingService {

    boolean postReservation(ReservationDto reservationDto);

    ReservationResponseDto getAllReservationByUserId(Long userId, int pageNumber);
}
