package com.hprms.controller;

import com.hprms.model.Role;
import com.hprms.model.User;
import com.hprms.repository.UserRepository;
import com.hprms.security.JwtUtil;
import com.hprms.service.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService,
                          JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User userRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword())
            );
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        Map<String, String> response = new HashMap<>();
        response.put("token", jwt);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User newUser = new User(
                userRequest.getUsername(),
                passwordEncoder.encode(userRequest.getPassword()),
                userRequest.getRole() != null ? userRequest.getRole() : Role.RECEPTIONIST
        );

        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }
}
