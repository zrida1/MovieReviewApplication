package com.example.moviewreviewapplication.dto;
import lombok.Data;

@Data
public class MovieRequestDTO {
    private String title;
    private String description;
    private String genre;
    private Integer releaseYear;
    private Double imdbRating;
}
