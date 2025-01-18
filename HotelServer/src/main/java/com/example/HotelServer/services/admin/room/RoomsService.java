package com.example.HotelServer.services.admin.room;

import com.example.HotelServer.dto.RoomDto;
import com.example.HotelServer.dto.RoomsResponseDto;

public interface RoomsService {

    boolean postRoom(RoomDto roomDto);

    RoomsResponseDto getAllRooms(int pageNumber);

    RoomDto getRoomById(Long id);
}
