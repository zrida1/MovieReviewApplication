package com.example.moviewreviewapplication.controller;

import com.example.moviewreviewapplication.dto.MovieRequestDTO;
import com.example.moviewreviewapplication.dto.MovieResponseDTO;
import com.example.moviewreviewapplication.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponseDTO> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieResponseDTO getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public MovieResponseDTO updateMovie(@PathVariable Long id, @RequestBody MovieRequestDTO movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDTO createNewMovie(@RequestBody MovieRequestDTO movie) {
        return movieService.createMovie(movie);

    }
}
