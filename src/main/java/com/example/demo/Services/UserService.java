package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        public User createUser( User user ){
            return userRepository.save(user);
        }

        public List<User> getUsers( User user ){
            return userRepository.findAll();
        }

        public Optional<User> getUserById( Long id ){
            return userRepository.findById(id);
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

        public User updateUser( Long id, User userDetails ){
            // check if user exists

                 User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new 
            RuntimeException("User not found"));

            // Edit fields
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setCourse(userDetails.getCourse());
            existingUser.setHomeAddress(userDetails.getHomeAddress());
            
            // Save user
            return userRepository.save(existingUser);



        }



}
