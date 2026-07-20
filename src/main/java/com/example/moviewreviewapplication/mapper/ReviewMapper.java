package com.example.moviewreviewapplication.mapper;

import com.example.moviewreviewapplication.dto.ReviewRequestDTO;
import com.example.moviewreviewapplication.dto.ReviewResponseDTO;
import com.example.moviewreviewapplication.entity.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewResponseDTO toResponseDTO(Review review);

    List<ReviewResponseDTO> toResponseDTOList(List<Review> reviews);

    Review toEntity(ReviewRequestDTO dto);
}
