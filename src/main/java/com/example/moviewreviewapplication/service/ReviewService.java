package com.example.moviewreviewapplication.service;

import com.example.moviewreviewapplication.dto.ReviewRequestDTO;
import com.example.moviewreviewapplication.dto.ReviewResponseDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewResponseDTO> getAllReviews();

    ReviewResponseDTO getReview(Long id);

    ReviewResponseDTO createReview(ReviewRequestDTO dto);

    ReviewResponseDTO updateReview(Long id, ReviewRequestDTO dto);

    void deleteReview(Long id);
}
