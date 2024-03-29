package com.example.reviewsmysql.service;

import com.example.reviewsmysql.entity.Review;
import com.example.reviewsmysql.repository.reviewRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class reviewServices {
    private reviewRepo reviewRepository ;



    public  void createReview(Review review ) {
        this.reviewRepository.save(review);
    }

    public Optional<Review> getReviewByd(Review review ){

        return this.reviewRepository.findById(review.getId());
    }
}
