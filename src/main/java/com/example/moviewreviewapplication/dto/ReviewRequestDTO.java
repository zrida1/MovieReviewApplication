package com.example.moviewreviewapplication.dto;

import lombok.Data;

@Data
public class ReviewRequestDTO {
    private Double rating;
    private String comment;
    private Long movieId;
    private Long userId;
}
