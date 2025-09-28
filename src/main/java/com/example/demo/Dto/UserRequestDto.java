package com.example.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// This dto represents what we want the user to send
public record UserRequestDto(
    @NotBlank( message = "Name is required" )
    String name,

    @NotBlank( message = "Address is required" )
    String address,

    @NotBlank( message = "Course is required" )
    String course,

    @Email( message = "Enter a valid email" )
    @NotBlank( message = "Email is required" )
    String email,

    @NotBlank( message = "Password is required" )
    @Size( min = 6, max = 12, message = "Password must be at least 6 characters and at most 12 characters long" )
    String password
) {
    
}
