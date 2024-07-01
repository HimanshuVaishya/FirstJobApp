package org.example.firstjobapp.service.Impl;

import org.example.firstjobapp.entity.Review;
import org.example.firstjobapp.repository.ReviewRepository;
import org.example.firstjobapp.service.CompanyService;
import org.example.firstjobapp.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> getAllReview(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        try{
            reviewRepository.save(review);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

    }

    @Override
    public boolean updateReviewById(Long companyId, Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findByCompanyId(companyId).stream().filter(review1 -> review1.getId().equals(reviewId)).findFirst().orElse(null);
        if(review != null){
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletById(Long companyId, Long reviewId) {
        if(reviewRepository.findByCompanyId(companyId) != null && reviewRepository.existsById(reviewId)){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
