package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Dto.UserResponseDto;
import com.example.demo.Entities.User;

@Component
public class UserDtoMapper {
    

    public User toEntity( UserRequestDto dto ){
        return new User(
            null,
            dto.name(), 
            dto.course(), 
            dto.email(), 
            dto.address(), 
            dto.password()
            );
    }

    public UserResponseDto toResponse( User user ){
        return new UserResponseDto(
            user.getId(), 
            user.getName(), 
            user.getEmail(), 
            user.getCourse()
            );
    }

}
