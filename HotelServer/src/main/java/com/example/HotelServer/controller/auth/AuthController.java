package com.example.HotelServer.controller.auth;

import com.example.HotelServer.dto.AuthenticationRequest;
import com.example.HotelServer.dto.AuthenticationResponse;
import com.example.HotelServer.dto.SignupRequest;
import com.example.HotelServer.dto.UserDto;
import com.example.HotelServer.entity.User;
import com.example.HotelServer.repository.UserRepository;
import com.example.HotelServer.services.auth.AuthService;
import com.example.HotelServer.util.JwtUtil;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.remote.JMXAuthenticator;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private UserRepository userRepository;


    public AuthController(AuthService authService, AuthenticationManager authenticationManager, UserRepository userRepository, JwtUtil jwtutil) {
        this.authService = authService;
    }


    @PostMapping("signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        try {
            UserDto createdUser = authService.createUser(signupRequest);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (EntityExistsException entityExistsException) {
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>("User not created, come again later", HttpStatus.BAD_REQUEST);


        }
    }

    @PostMapping("/login")

    //- Implement POST /login for authenticating users.

    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, JMXAuthenticator authenticationManager, JwtUtil jwtUtil) {
        // - Verify user credentials using AuthenticationManager.
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = null;
        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        // - Generate JWT token upon successful authentication.
        final String jwt = jwtUtil.generateToken(userDetails);
        
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if(optionalUser.isPresent()){
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
            authenticationResponse.setUserId(optionalUser.get().getId());
        }
        return authenticationResponse;
    }
}
