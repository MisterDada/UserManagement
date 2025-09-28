package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Dto.UserResponseDto;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUser( @RequestBody UserRequestDto userRequest){
        return 
            ResponseEntity.ok( userService.getUsers() );
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser( @RequestBody UserRequestDto userRequest ) {
        return new 
            ResponseEntity<>( userService.createUser(userRequest), HttpStatus.CREATED );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById( @PathVariable Long id ){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser( @PathVariable Long id ){
         userService.deleteUser(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser( @PathVariable Long id, @RequestBody UserRequestDto userRequest ){
        return ResponseEntity.ok(userService.updateUser(id, userRequest));
    }
    

}
