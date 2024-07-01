package org.example.firstjobapp.service;

import org.example.firstjobapp.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(Long companyId);
    boolean addReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);

    boolean updateReviewById(Long companyId, Long reviewId, Review updatedReview);

    boolean deletById(Long companyId, Long reviewId);
}
