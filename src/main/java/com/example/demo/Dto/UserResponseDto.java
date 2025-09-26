package com.example.demo.Dto;


// This dto represents what we end to the user / frontend
public record UserResponseDto(
    Long id,
    String name,
    String email,
    String course
) {
    
}
