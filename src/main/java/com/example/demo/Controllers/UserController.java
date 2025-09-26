package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.User;
import com.example.demo.Repository.UserRepository;
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
    public List<User> getUser(User user){
        return userService.getUsers(user);
    }

    @PostMapping
    public User createUser( @RequestBody User user ) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById( @PathVariable Long id ){
        return userService.getUserById(id)
        .orElseThrow(() ->  new 
        RuntimeException("User not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteUser( @PathVariable Long id ){
         userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser( @PathVariable Long id, @RequestBody User user ){
        return userService.updateUser(id, user);
    }
    

}
