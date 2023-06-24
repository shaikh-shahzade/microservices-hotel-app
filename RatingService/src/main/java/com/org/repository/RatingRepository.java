package com.org.repository;

import com.org.enitity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {
    public List<Rating> findRatingByUserId(Long userId);
}
