package com.example.moviewreviewapplication.controller;

import com.example.moviewreviewapplication.dto.ReviewRequestDTO;
import com.example.moviewreviewapplication.dto.ReviewResponseDTO;
import com.example.moviewreviewapplication.entity.Review;
import com.example.moviewreviewapplication.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping
    public Page<ReviewResponseDTO> getAllReviews(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size, @RequestParam(defaultValue = "rating") String sortBy) {
        return reviewService.getAllReviews(page, size, sortBy);
    }
    @GetMapping("/{id}")
    public ReviewResponseDTO getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponseDTO createReview(@Valid @RequestBody ReviewRequestDTO dto) {
        return reviewService.createReview(dto);
    }
    @PutMapping("/{id}")
    public ReviewResponseDTO updateReview(@PathVariable Long id, @Valid @RequestBody ReviewRequestDTO dto) {
        return reviewService.updateReview(id, dto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
