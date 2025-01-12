package com.example.HotelServer.dto;


import lombok.Data;

@Data
public class SignupRequest {

    private String email;

    private String password;

    private String name;


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public CharSequence getPassword() {
        return password;
    }
}
