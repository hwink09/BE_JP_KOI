package com.example.Koi_Order_System.service;


import com.example.Koi_Order_System.model.payload.DTO.LoginDto;
import com.example.Koi_Order_System.model.payload.DTO.SignupDto;
import com.example.Koi_Order_System.model.payload.responseModel.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
    AuthenticationResponse login(LoginDto loginDto);
    String signup(SignupDto signupDto);
    AuthenticationResponse refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
