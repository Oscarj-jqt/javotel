package com.example.HotelServer.services.customer.booking;


import com.example.HotelServer.dto.ReservationDto;
import com.example.HotelServer.entity.Reservation;
import com.example.HotelServer.entity.Room;
import com.example.HotelServer.entity.User;
import com.example.HotelServer.enums.ReservationStatus;
import com.example.HotelServer.repository.ReservationRepository;
import com.example.HotelServer.repository.RoomRepository;
import com.example.HotelServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final UserRepository userRepository;

    private final RoomRepository roomRepository;
    
    private ReservationRepository reservationRepository = null;

    public BookingServiceImpl(UserRepository userRepository, RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public boolean postReservation(ReservationDto reservationDto){
        Optional<User> optionalUser = userRepository.findById(reservationDto.getUserId());
        Optional<Room> optionalRoom = roomRepository.findById(reservationDto.getRoomId());


        if(optionalRoom.isPresent() && optionalUser.isPresent()){
            Reservation reservation = new Reservation();

            reservation.setRoom(optionalRoom.get());
            reservation.setUser(optionalUser.get());
            reservation.setCheckInDate(reservationDto.getCheckInDate());
            reservation.setCheckOutDate(reservationDto.getCheckOutDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);

            Long days = ChronoUnit.DAYS.between(reservationDto.getCheckInDate(), reservationDto.getCheckOutDate());
            reservation.setPrice(optionalRoom.get().getPrice()*days);

            reservationRepository.save(reservation);
            return true;
        }
        return false;

    }
    
}
