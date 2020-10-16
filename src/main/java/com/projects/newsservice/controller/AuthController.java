package com.projects.newsservice.controller;

import com.projects.newsservice.Service.AuthService;
import com.projects.newsservice.dto.LoginCredentials;
import com.projects.newsservice.dto.LoginResponse;
import com.projects.newsservice.dto.UserDto;
import com.projects.newsservice.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private UserRepo userRepo;

    public AuthController(AuthService authService, UserRepo userRepo) {
        this.authService = authService;
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDTO) {
        return authService.register(userDTO);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<LoginResponse> login(@RequestBody LoginCredentials loginCredentials) {
        return authService.login(loginCredentials);
    }

}
