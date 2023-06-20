package com.org.service;

import com.org.enitity.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingService {
    public ResponseEntity<List<Rating>> getAllRatings();

    public ResponseEntity<Rating> getRatingsById(String id);

    public ResponseEntity<Rating> createRating(Rating rating);
}
