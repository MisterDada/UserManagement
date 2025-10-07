package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Dto.UserResponseDto;
import com.example.demo.Entities.User;

@Component
public class UserDtoMapper {
    

   public User toEntity( UserRequestDto request ){
        return new User(
            null, 
            request.name(), 
            null, 
            request.email(), 
            null, 
            request.password(), 
            null
            );
   }

    public UserResponseDto toResponse( User user ){
        return new UserResponseDto(
            user.getId(), 
            user.getName(), 
            user.getEmail(),
            user.getProduct()
            );
    }

}
