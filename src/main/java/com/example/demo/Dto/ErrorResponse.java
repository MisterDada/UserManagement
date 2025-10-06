package com.example.demo.Dto;

public record ErrorResponse(

    int Status,
    String message,
    String details

) {
    
}
