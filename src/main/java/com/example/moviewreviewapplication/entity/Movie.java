package com.example.moviewreviewapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String genre;
    private Integer releaseYear;
    private Double imdbRating;
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

}
