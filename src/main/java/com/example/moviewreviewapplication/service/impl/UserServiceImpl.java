package com.example.moviewreviewapplication.service.impl;

import com.example.moviewreviewapplication.dto.UserRequestDTO;
import com.example.moviewreviewapplication.dto.UserResponseDTO;
import com.example.moviewreviewapplication.entity.User;
import com.example.moviewreviewapplication.exception.ResourceNotFoundException;
import com.example.moviewreviewapplication.mapper.UserMapper;
import com.example.moviewreviewapplication.repository.UserRepository;
import com.example.moviewreviewapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userMapper.toResponseDTO(userRepository.findAll());
    }
    public UserResponseDTO getUser(Long id) {
        return userMapper.toResponseDTO(userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id: " + id)));
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        return userMapper.toResponseDTO(userRepository.save(userMapper.toEntity(userRequestDTO)));
    }
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO){
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id: " + id));
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        return userMapper.toResponseDTO(userRepository.save(user));
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }
}
