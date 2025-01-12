package com.example.HotelServer.services.auth;


import com.example.HotelServer.dto.SignupRequest;
import com.example.HotelServer.dto.UserDto;
import com.example.HotelServer.entity.User;
import com.example.HotelServer.enums.UserRole;
import com.example.HotelServer.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.hibernate.EntityFilterException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

//It manages authentication and users
public class AuthServiceImpl implements AuthService {

    public interface AuthService {
        UserDto createUser(SignupRequest signupRequest) throws EntityExistsException;
    }

    // Dependency injection of UserRepository to interact with the database
    private final UserRepository userRepository;

    // Constructor in case Lombok is not used for some reason
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createAnAdminAccount(){
        // Check if an admin account already exists in the database
        Optional<User> adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if(adminAccount.isEmpty()){
            // Create a new User object for the admin account
            User user = new User();

            // Set default admin credentials
            user.setEmail("admin@test.com");
            user.setName("Admin");
            user.setUserRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));

            // Save the admin user in the database
            userRepository.save(user);

            // Display a success message
            System.out.print("Admin account created successfully");

        }else{
            System.out.println("Admin account already exists");
        }

    }


    public UserDto createUser(SignupRequest signupRequest) throws EntityFilterException {
        // Check if this email exists
        if(userRepository.findFirstByEmail(signupRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User Already Present With email " + signupRequest.getEmail());
        }

        // Create a new object with data from SignupRequest
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setUserRole(UserRole.CUSTOMER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        User createdUser = userRepository.save(user);
        return createdUser.getUserDto();
    }


}
