package com.example.moviewreviewapplication.controller;


import com.example.moviewreviewapplication.dto.UserRequestDTO;
import com.example.moviewreviewapplication.dto.UserResponseDTO;
import com.example.moviewreviewapplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Users", description = "User Management APIs")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public Page<UserResponseDTO> getAllUsers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size, @RequestParam(defaultValue = "name") String sortBy) {
        return userService.getAllUsers(page, size, sortBy);
    }

    @Operation(summary = "Get user by id")
    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO user) {
        return userService.updateUser(id, user);
    }

    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

    }

    @Operation(summary = "Create new user")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO user) {
        return userService.createUser(user);

    }
}


