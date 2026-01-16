package com.glowcart.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.glowcart.api.entity.User;
import com.glowcart.api.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    public User login(@RequestParam String name, @RequestParam String mobile) {

        return userRepo.findByMobile(mobile)
                .orElseGet(() -> userRepo.save(new User(null, name, mobile)));
    }
}