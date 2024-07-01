package org.example.firstjobapp.controller;

import org.example.firstjobapp.entity.Review;
import org.example.firstjobapp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isAdded = reviewService.addReview(companyId, review);
        if(isAdded){
            return new ResponseEntity<>("review added", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("review not added", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId, reviewId);
        if(review != null){
            return ResponseEntity.ok(review);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review updatedReview){
        boolean isUpdated = reviewService.updateReviewById(companyId, reviewId, updatedReview);
        if(isUpdated)
            return ResponseEntity.ok("review updated");
        return new ResponseEntity<>("not updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isDeleted = reviewService.deletById(companyId, reviewId);
        if(isDeleted)
            return ResponseEntity.ok("deleted successfully");
        return new ResponseEntity<>("not deleted", HttpStatus.NOT_FOUND);
    }

}
