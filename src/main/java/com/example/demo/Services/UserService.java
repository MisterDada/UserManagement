package com.example.demo.Services;

import java.util.List;

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
            return null;
        }

        public List<User> getUsers( User user ){
            return null;
        }

        public void deleteUser( Long id ){
            
        }

        public User findUser( Long id ){
            return null;
        }



}
