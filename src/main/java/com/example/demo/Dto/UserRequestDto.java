package com.example.demo.Dto;


// This dto represents what we want the user to send
public record UserRequestDto(
    String name,
    String address,
    String course,
    String email,
    String password
) {
    
}
