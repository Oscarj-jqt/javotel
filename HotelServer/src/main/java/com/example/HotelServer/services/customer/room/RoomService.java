package com.example.HotelServer.services.customer.room;

import com.example.HotelServer.dto.RoomsResponseDto;

public interface RoomService {

    RoomsResponseDto getAvailableRooms(int pageNumber);
}
