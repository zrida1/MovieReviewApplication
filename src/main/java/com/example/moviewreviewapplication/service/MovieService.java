package com.example.moviewreviewapplication.service;

import com.example.moviewreviewapplication.dto.MovieRequestDTO;
import com.example.moviewreviewapplication.dto.MovieResponseDTO;

import java.util.List;


public interface MovieService {


    MovieResponseDTO getMovieById(Long id);

    List<MovieResponseDTO> getAllMovies();
    MovieResponseDTO updateMovie(Long id, MovieRequestDTO dto);

    void deleteMovie(Long id);
    MovieResponseDTO createMovie(MovieRequestDTO dto);
}
