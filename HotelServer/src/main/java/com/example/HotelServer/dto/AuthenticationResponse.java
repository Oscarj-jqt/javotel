package com.example.HotelServer.dto;


import com.example.HotelServer.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private Long userId;

    private Object userRole;

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserRole(Object userRole) {
        this.userRole = (UserRole) userRole;
    }

    public Object getUserRole() {
        return userRole;
    }
}
