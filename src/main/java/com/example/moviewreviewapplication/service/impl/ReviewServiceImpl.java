package com.example.moviewreviewapplication.service.impl;

import com.example.moviewreviewapplication.dto.ReviewRequestDTO;
import com.example.moviewreviewapplication.dto.ReviewResponseDTO;
import com.example.moviewreviewapplication.entity.Movie;
import com.example.moviewreviewapplication.entity.Review;
import com.example.moviewreviewapplication.entity.User;
import com.example.moviewreviewapplication.mapper.ReviewMapper;
import com.example.moviewreviewapplication.repository.MovieRepository;
import com.example.moviewreviewapplication.repository.ReviewRepository;
import com.example.moviewreviewapplication.repository.UserRepository;
import com.example.moviewreviewapplication.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReviewMapper reviewMapper;
    ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, MovieRepository movieRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewResponseDTO> getAllReviews(){
        return reviewMapper.toResponseDTOList(reviewRepository.findAll());
    }

    public ReviewResponseDTO getReview(Long id){
        return reviewMapper.toResponseDTO(reviewRepository.findById(id).orElseThrow());
    }

    public ReviewResponseDTO createReview(ReviewRequestDTO dto){
        Movie movie = movieRepository.findById(dto.getMovieId()).orElseThrow();
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        Review review = reviewMapper.toEntity(dto);
        review.setMovie(movie);
        review.setUser(user);
        return   reviewMapper.toResponseDTO(reviewRepository.save(review));
    }

    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO dto){
        Review review = reviewRepository.findById(id).orElseThrow();
        Movie movie = movieRepository.findById(dto.getMovieId()).orElseThrow();
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setMovie(movie);
        review.setUser(user);
        return   reviewMapper.toResponseDTO(reviewRepository.save(review));
    }

    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }

}
