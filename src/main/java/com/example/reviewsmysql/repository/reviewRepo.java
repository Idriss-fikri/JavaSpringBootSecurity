package com.example.reviewsmysql.repository;

import com.example.reviewsmysql.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reviewRepo  extends JpaRepository<Review, Long> {
}
