package com.example.moviewreviewapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double rating;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
