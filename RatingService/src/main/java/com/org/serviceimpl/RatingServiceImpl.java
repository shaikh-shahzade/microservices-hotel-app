package com.org.serviceimpl;

import com.org.enitity.Rating;
import com.org.exception.ResourceNotFoundException;
import com.org.repository.RatingRepository;
import com.org.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingRepository.findAll();
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> getRatingsById(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Rating","Rating",id));
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> createRating(Rating rating) {
        Rating r = ratingRepository.save(rating);
        return new ResponseEntity<Rating>(r, HttpStatus.CREATED);
    }
}
