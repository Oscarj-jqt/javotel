package com.example.HotelServer.services.admin.reservation;

import com.example.HotelServer.dto.ReservationResponseDto;

public interface ReservationService {

    ReservationResponseDto getAllReservations(int pageNumber);
}
