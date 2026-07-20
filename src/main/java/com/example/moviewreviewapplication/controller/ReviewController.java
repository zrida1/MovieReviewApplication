package com.example.moviewreviewapplication.controller;

import com.example.moviewreviewapplication.dto.ReviewRequestDTO;
import com.example.moviewreviewapplication.dto.ReviewResponseDTO;
import com.example.moviewreviewapplication.entity.Review;
import com.example.moviewreviewapplication.service.ReviewService;
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
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @GetMapping("/{id}")
    public ReviewResponseDTO getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }
    @PostMapping
    public ReviewResponseDTO createReview(@RequestBody ReviewRequestDTO dto) {
        return reviewService.createReview(dto);
    }
    @PutMapping("/{id}")
    public ReviewResponseDTO updateReview(@PathVariable Long id, @RequestBody ReviewRequestDTO dto) {
        return reviewService.updateReview(id, dto);
    }
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
