package com.example.Koi_Order_System.controller;


import com.example.Koi_Order_System.model.payload.DTO.LoginDto;
import com.example.Koi_Order_System.model.payload.DTO.SignupDto;
import com.example.Koi_Order_System.model.payload.responseModel.AuthenticationResponse;
import com.example.Koi_Order_System.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/no-auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = {"/login"})
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody LoginDto loginDto){
        AuthenticationResponse token = authService.login(loginDto);
        return  ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupDto signupDto){
        String response = authService.signup(signupDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        return ResponseEntity.ok(authService.refreshToken(request, response));
    }

}
