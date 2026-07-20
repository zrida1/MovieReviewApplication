package com.example.moviewreviewapplication.controller;


import com.example.moviewreviewapplication.dto.UserRequestDTO;
import com.example.moviewreviewapplication.dto.UserResponseDTO;
import com.example.moviewreviewapplication.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO user) {
        return userService.createUser(user);

    }
}

