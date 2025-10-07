package com.example.demo.Services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Dto.UserResponseDto;
import com.example.demo.Entities.User;
import com.example.demo.Mapper.UserDtoMapper;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public UserService(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

        public UserResponseDto createUser( UserRequestDto request ){
           // Convert DTO to entity using mapper
           User user = userDtoMapper.toEntity(request);

            User savedUser = userRepository.save(user);

            // Convert entity to DTO using mapper
            return userDtoMapper.toResponse(savedUser);
        }

        public List<UserResponseDto> getUsers(){
            List<User> users = userRepository.findAll();

            return users.stream()
                .map( user -> 
                    userDtoMapper.toResponse(user))
                    .toList();
               
        }

        public UserResponseDto getUserById( Long id ){
            User user = userRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found") );

            return userDtoMapper.toResponse(user);
            
        }

        public void deleteUser( Long id ){
            // Check if user exists
            User existingUser = userRepository.findById(id)
                .orElseThrow( () -> new 
                    RuntimeException("User does not exist")
                 );
            // delete user
            userRepository.delete(existingUser);
        }

        public UserResponseDto updateUser( Long id, UserRequestDto requestDto ){
            // check if user exists

                 User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new 
            RuntimeException("User not found"));

            // Edit fields
            existingUser.setName(requestDto.name());
            existingUser.setEmail(requestDto.email());
            
            // Save user
             userRepository.save(existingUser);

                return userDtoMapper.toResponse(existingUser);


        }



}
