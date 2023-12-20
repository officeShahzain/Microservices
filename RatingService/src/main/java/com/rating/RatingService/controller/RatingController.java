package com.rating.RatingService.controller;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;
    @PostMapping("/add")
    public ResponseEntity<String> addRating(@RequestBody Rating rating)
    {
        Rating newRating = ratingService.create(rating);
        return ResponseEntity.ok("Rating Save Successfully !!");
    }
    @GetMapping("/getRating")
    public ResponseEntity<List<Rating>> getListOfRating()
    {
        List<Rating> listOfRating = ratingService.getAllRating();
        return ResponseEntity.status(HttpStatus.OK).body(listOfRating);
    }
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Rating>> getRatingWithUserId(@PathVariable("userId")String userId)
    {
        List<Rating> listOfRating = ratingService.getRatingByUserId(userId);
        return  new ResponseEntity<>(listOfRating,HttpStatus.FOUND);
    }
    @GetMapping("/getRatingHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingWithHotelId(@PathVariable("hotelId")String hotelId)
    {
        List<Rating> listOfRating = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(listOfRating, HttpStatus.FOUND);
    }
}
