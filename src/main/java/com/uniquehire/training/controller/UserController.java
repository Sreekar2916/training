package com.uniquehire.training.controller;

import com.uniquehire.training.dto.UserRequestDTO;
import com.uniquehire.training.dto.UserResponseDTO;
import com.uniquehire.training.model.User;
import com.uniquehire.training.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserRequestDTO user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.getAllUsers();
    }
}
