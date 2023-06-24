package com.org.controller;

import com.org.enitity.Rating;
import com.org.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        return  ratingService.getAllRatings();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingsById(@PathVariable String id)
    {
        return  ratingService.getRatingsById(id);
    }
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        return  ratingService.createRating(rating);
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Long userId)
    {
        return ratingService.getRatingsByUserId(userId);
    }

}
