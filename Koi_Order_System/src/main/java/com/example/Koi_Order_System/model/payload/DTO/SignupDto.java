package com.example.Koi_Order_System.model.payload.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {
    @NotEmpty(message = "Username should not be empty!")
    private String username;

    @Email(regexp = ".+@.+\\..+", message = "Email is invalid!")
    private String email;

    @NotEmpty(message = "Password should not be empty!")
    private String password;

    @NotEmpty(message = "Full name should not be empty!")
    private String fullName;

    @NotEmpty(message = "Address should not be empty!")
    private String address;

    @NotEmpty(message = "Phone number should not be empty!")
    @Pattern(regexp="(^$|[0-9]{10,11})", message = "Phone number must be 10 or 11 digits!")
    private String phone;
}
