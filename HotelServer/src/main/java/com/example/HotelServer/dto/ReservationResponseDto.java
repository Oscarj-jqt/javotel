package com.example.HotelServer.dto;

import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

@Data
public class ReservationResponseDto {

    private Integer totalPages;

    private Integer pageNumber;

    private List<ReservationDto> reservationDtoList;

    public Object setReservationDtoList(Stream<ReservationDto> reservationDtoStream) {
        return this.reservationDtoList = reservationDtoList;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<ReservationDto> getReservationDtoList() {
        return reservationDtoList;
    }

    public void setReservationDtoList(List<ReservationDto> reservationDtoList) {
        this.reservationDtoList = reservationDtoList;
    }
}
