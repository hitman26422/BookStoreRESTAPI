package com.example.bookstore.api.controller;

import com.example.bookstore.model.User;
import com.example.bookstore.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public User createUser(@RequestBody User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted user with ID: " + id;
    }
}
