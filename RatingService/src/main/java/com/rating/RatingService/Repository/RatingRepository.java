package com.rating.RatingService.Repository;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.rating.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
