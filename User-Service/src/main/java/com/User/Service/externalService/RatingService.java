package com.User.Service.externalService;

import com.User.Service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @PostMapping("/rating/add")
    String createRating(Rating rating);
    @PutMapping("/rating/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
}
