package com.example.HotelServer.dto;


import com.example.HotelServer.enums.UserRole;
import lombok.Data;


@Data
public class UserDto {

    private Long id;

    private String email;

    private String name;

    private UserRole userRole;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
