package com.example.HotelServer.repository;

import com.example.HotelServer.entity.User;
import com.example.HotelServer.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Interact with database
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Finds the first user with the specified email address
    Optional<User> findFirstByEmail(String email);

    //Finds a user with the specified role
    Optional<User> findByUserRole(UserRole userRole);

}
