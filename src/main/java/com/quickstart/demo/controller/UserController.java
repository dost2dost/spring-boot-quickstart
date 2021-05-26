package com.quickstart.demo.controller;

import com.quickstart.demo.Entity.User;
import com.quickstart.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/save/user")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

}
