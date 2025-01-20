package com.example.HotelServer.services.customer.booking;

import com.example.HotelServer.dto.ReservationDto;

public interface BookingService {

    boolean postReservation(ReservationDto reservationDto);
}
