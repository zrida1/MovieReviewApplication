package com.example.moviewreviewapplication.dto;

import com.example.moviewreviewapplication.entity.Review;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
}
