package com.example.reviewsmysql.controller;

import com.example.reviewsmysql.entity.Review;
import com.example.reviewsmysql.service.reviewServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "review")
@RestController
@AllArgsConstructor

public class reviewController {

    private reviewServices reviewService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void CreateReview(@RequestBody Review review) {
        this.reviewService.createReview(review);

    }
}

