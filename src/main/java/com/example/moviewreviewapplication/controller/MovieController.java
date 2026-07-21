package com.example.moviewreviewapplication.controller;

import com.example.moviewreviewapplication.dto.MovieRequestDTO;
import com.example.moviewreviewapplication.dto.MovieResponseDTO;
import com.example.moviewreviewapplication.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Page<MovieResponseDTO> getMovies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "title") String sortBy) {
        return movieService.getAllMovies(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public MovieResponseDTO getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public MovieResponseDTO updateMovie(@PathVariable Long id, @Valid @RequestBody MovieRequestDTO movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDTO createNewMovie(@Valid @RequestBody MovieRequestDTO movie) {
        return movieService.createMovie(movie);

    }
}
