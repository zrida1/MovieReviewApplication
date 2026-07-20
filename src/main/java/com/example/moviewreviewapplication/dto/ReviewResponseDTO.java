package com.example.moviewreviewapplication.dto;

import lombok.Data;

@Data
public class ReviewResponseDTO {
    private Long id;
    private Double rating;
    private String comment;
    private String movieTitle;
    private String userName;
}
